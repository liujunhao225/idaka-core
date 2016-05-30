package cn.com.idaka.core.message.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.activation.MimetypesFileTypeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//import org.apache.catalina.util.URLEncoder;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sun.xml.internal.fastinfoset.Encoder;

import cn.com.idaka.core.enumeration.SCOPE;
import cn.com.idaka.core.exception.AccessTokenException;
import cn.com.idaka.core.exception.PermissionException;
import cn.com.idaka.core.exception.WeixinApiException;
import cn.com.idaka.core.message.helper.bean.XMLReturn;
import cn.com.idaka.core.message.parts.News;
import cn.com.idaka.core.mongodb.model.Setting;
import cn.com.idaka.core.mongodb.model.User;
import cn.com.idaka.core.util.Config;
import cn.com.idaka.core.util.FileStorage;
import cn.com.idaka.core.util.JsonUtil;
import cn.com.idaka.core.util.MD5;
import cn.com.idaka.core.util.SHA1;
import cn.com.idaka.core.util.StringUtil;

public class WeixinAPI {

	private static final Logger logger = LoggerFactory.getLogger(WeixinAPI.class);

	protected String appid = null;
	protected String appsecret = null;
	protected static Map<String, JSONObject> tokenStock = new HashMap<String, JSONObject>();
	protected static Map<String, JSONObject> webTokenStock = new HashMap<String, JSONObject>();
	protected static Map<String, JSONObject> jsTokenStock = new HashMap<String, JSONObject>();
	protected static Map<String, JSONObject> cardTokenStock = new HashMap<String, JSONObject>();

	protected MongoTemplate mongo;

	/**
	 * 以GET方式访问指定地址，获取JSON
	 * 
	 * @param url
	 * @return
	 * @throws WeixinApiException
	 */
	protected JSONObject jsonGet(String urls) throws WeixinApiException {

		JSONObject jsonObject = null;
		// HTTP

		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };
			// Install the all-trusting trust manager
			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

			URL url = new URL(urls);
			URLConnection con = url.openConnection();

			final Reader reader = new InputStreamReader(con.getInputStream(), "utf-8");
			final BufferedReader br = new BufferedReader(reader);

			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			logger.debug(sb.toString());

			jsonObject = new JSONObject(sb.toString());
			if (jsonObject.has("errcode") && jsonObject.getInt("errcode") > 0) {
				logger.error("there is a error occured:(".concat(jsonObject.getString("errcode")).concat(")")
						.concat(jsonObject.getString("errmsg")));

				if (jsonObject.getInt("errcode") == 40001) {
					this.refreshAccessToken();
				}

				throw new PermissionException(jsonObject.getString("errmsg"));
			}
		} catch (JSONException e) {
			logger.error("微信API数据格式错误！");
			logger.error(e.getMessage());
			throw new WeixinApiException("微信API数据格式错误！");
		} catch (Exception e) {
			logger.error("微信API通信错误！");
			logger.error(e.getMessage());
			if (logger.isDebugEnabled())
				e.printStackTrace();
			throw new WeixinApiException("微信API通信错误！");
		}

		return jsonObject;

	}

	public WeixinAPI(String appid, String appsecret) {
		super();
		this.appid = appid;
		this.appsecret = appsecret;
	}

	public WeixinAPI(String appid, String appsecret, MongoTemplate mongo) {
		super();
		this.appid = appid;
		this.appsecret = appsecret;
		this.mongo = mongo;
	}

	/**
	 * 提交JSON数据，返回JSON数据
	 * 
	 * @param url
	 * @param text
	 * @return
	 * @throws AccessTokenException
	 */
	protected JSONObject jsonPost(String urls, String text) throws WeixinApiException {

		JSONObject jsonObject = null;

		try {

			logger.debug(urls);
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };
			// Install the all-trusting trust manager
			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

			URL url = new URL(urls);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "utf-8"));
			writer.write(text);
			writer.close();
			final Reader reader = new InputStreamReader(con.getInputStream(), "utf-8");
			final BufferedReader br = new BufferedReader(reader);

			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();

			jsonObject = new JSONObject(sb.toString());
			if (jsonObject.has("errcode") && jsonObject.getInt("errcode") > 0) {
				logger.error("there is a error occured:(".concat(jsonObject.getString("errcode")).concat(")")
						.concat(jsonObject.getString("errmsg")));

				if (jsonObject.getInt("errcode") == 40001) {
					this.refreshAccessToken();
				}

				// throw new
				// PermissionException(jsonObject.getString("errmsg"));
			}
		} catch (JSONException e) {
			logger.error("微信API数据格式错误！");
			logger.error(e.getMessage());
			throw new WeixinApiException(e.getMessage());
		} catch (Exception e) {
			logger.error("微信API通信错误！");
			logger.error(e.getMessage());
			throw new WeixinApiException(e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 提交JSON数据，返回JSON数据
	 * 
	 * @param url
	 * @param text
	 * @return
	 * @throws AccessTokenException
	 */
	protected XMLReturn xmlPost(String urls, String text) throws WeixinApiException {

		try {

			logger.debug(urls);
			logger.debug(text);
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };
			// Install the all-trusting trust manager
			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

			URL url = new URL(urls);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "utf-8"));
			writer.write(text);
			writer.close();
			final Reader reader = new InputStreamReader(con.getInputStream(), "utf-8");

			Unmarshaller um = JAXBContext.newInstance(XMLReturn.class).createUnmarshaller();
			return (XMLReturn) um.unmarshal(reader);

		} catch (Exception e) {
			logger.error("微信API通信错误！");
			logger.error(e.getMessage());
			throw new WeixinApiException(e.getMessage());
		}
	}

	protected JSONObject newToken() throws WeixinApiException {
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=").append(appid)
				.append("&secret=").append(appsecret);
		return this.jsonGet(url.toString());

	}

	public String getAccessToken() throws WeixinApiException {
		try {
			JSONObject access_token = tokenStock.get(appid);
			if (access_token != null && access_token.has("expires")
					&& access_token.getLong("expires") > System.currentTimeMillis()) {
				return access_token.getString("access_token");
			} else {
				JSONObject newtoken = newToken();
				if (newtoken.has("expires_in") && newtoken.getInt("expires_in") > 0) {
					newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000);
					tokenStock.put(this.appid, newtoken);
					return newtoken.getString("access_token");
				} else {
					throw new AccessTokenException("Can't get access_token");
				}
			}
		} catch (JSONException e) {
			throw new AccessTokenException(e);
		}
	}

	protected void refreshAccessToken() throws WeixinApiException {
		try {
			JSONObject newtoken = newToken();
			if (newtoken.has("expires_in") && newtoken.getInt("expires_in") > 0) {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000);
				tokenStock.put(this.appid, newtoken);
			} else {
				throw new AccessTokenException("Can't get access_token");
			}
		} catch (JSONException e) {
			throw new AccessTokenException(e);
		}
	}

	public JSONObject publishMenu(String menutext) throws WeixinApiException {

		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=".concat(getAccessToken());
		return this.jsonPost(url, menutext);
	}

	/**
	 * 
	 * @param userid
	 * @return 返回JSON格式 { "subscribe": 1, "openid":
	 *         "o6_bmjrPTlm6_2sgVt7hMZOPfL2M", "nickname": "Band", "sex": 1,
	 *         "language": "zh_CN", "city": "广州", "province": "广东", "country":
	 *         "中国", "headimgurl":
	 *         "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
	 *         "subscribe_time": 1382694957 }
	 * @throws AccessTokenException
	 */
	public User getUser(String userid) throws WeixinApiException {
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/user/info?access_token=").append(getAccessToken())
				.append("&openid=").append(userid);
		User user = new User();
		JSONObject wxUser = this.jsonGet(url.toString());
		try {
			if (wxUser.has("city"))
				user.setCity(wxUser.getString("city"));
			if (wxUser.has("headimgurl"))
				user.setLogo(wxUser.getString("headimgurl"));
			if (wxUser.has("nickname"))
				user.setNickname(wxUser.getString("nickname"));
			if (wxUser.has("country"))
				user.setCountry(wxUser.getString("country"));
			if (wxUser.has("province"))
				user.setProvince(wxUser.getString("province"));
			if (wxUser.has("sex"))
				user.setSex(wxUser.getInt("sex"));
			if (wxUser.has("language"))
				user.setLanguage(wxUser.getString("language"));
		} catch (JSONException e) {
			logger.error(e.getMessage());
			return null;
		}

		return user;
	}

	public JSONObject queryUserGroup() throws WeixinApiException {
		String url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=".concat(this.getAccessToken());
		return this.jsonGet(url);
	}

	// 生成数字场景二维码
	public String getQRTicket(boolean limit, int sceneid) throws WeixinApiException {
		try {
			// https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
			JSONObject param = new JSONObject();
			if (limit) {
				param.put("action_name", "QR_LIMIT_SCENE");
			} else {
				param.put("action_name", "QR_SCENE");
				param.put("expire_seconds", 1800);
			}
			JSONObject actioninfo = new JSONObject();
			JSONObject scene = new JSONObject();
			scene.put("scene_id", sceneid);
			actioninfo.put("scene", scene);
			param.put("action_info", actioninfo);

			if (logger.isDebugEnabled()) {
				logger.debug("二维码请求参数：".concat(param.toString()));
			}

			String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=".concat(this.getAccessToken());
			JSONObject rets = this.jsonPost(url, param.toString());
			if (rets.has("ticket")) {
				try {
					return URLEncoder.encode(rets.getString("ticket"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return "";
				}
			} else {
				return null;
			}
		} catch (JSONException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// 生成字符串场景二维码
	public String getStrQRTicket(String strScene) throws WeixinApiException {
		try {
			JSONObject param = new JSONObject();
			param.put("action_name", "QR_LIMIT_STR_SCENE");
			JSONObject actioninfo = new JSONObject();
			JSONObject scene = new JSONObject();
			scene.put("scene_str", strScene);
			actioninfo.put("scene", scene);
			param.put("action_info", actioninfo);

			if (logger.isDebugEnabled()) {
				logger.debug("字符串二维码请求参数：".concat(param.toString()));
			}

			String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=".concat(this.getAccessToken());
			JSONObject rets = this.jsonPost(url, param.toString());
			if (rets.has("ticket")) {
				try {
					return URLEncoder.encode(rets.getString("ticket"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return null;
				}
				// return new URLEncoder().encode(rets.getString("ticket"));
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 设置卡券用户白名单
	 * 
	 * @return
	 */
	public void setCardWhiteOpenid(String openid) throws WeixinApiException {
		JSONObject json = new JSONObject();
		try {
			List<String> openidList = new ArrayList<String>();
			openidList.add(openid);

			json.put("openid", openidList);
			logger.debug(json.toString());

			String url = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=".concat(getAccessToken());
			JSONObject rets = this.jsonPost(url, json.toString());
			logger.debug(rets.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			throw new WeixinApiException("set_card_white_users_failed");
		}
	}

	/**
	 * 核销卡券code
	 * 
	 * @return
	 */
	public String consumeCardCode(JSONObject params) {
		try {
			String url = "https://api.weixin.qq.com/card/code/consume?access_token=".concat(this.getAccessToken());
			logger.debug(params.toString());
			JSONObject rets = this.jsonPost(url, params.toString());
			logger.debug(rets.toString());

			return rets.toString();
		} catch (WeixinApiException e) {
			e.printStackTrace();
			return "failure";
		}
	}

	/* ===================卡券测试 end ================== */
	/**
	 * @param code
	 * @return { "access_token":"ACCESS_TOKEN", "expires_in":7200,
	 *         "refresh_token":"REFRESH_TOKEN", "openid":"OPENID",
	 *         "scope":"SCOPE" }
	 * @throws WeixinApiException
	 */
	public String getWebVisitorOpenId(String code) throws WeixinApiException {

		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=").append(this.appid).append("&secret=").append(this.appsecret);
		url.append("&code=").append(code).append("&grant_type=authorization_code");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				return newtoken.getString("openid");
			} catch (JSONException e) {
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	/**
	 * @param code
	 * @return { "access_token":"ACCESS_TOKEN", "expires_in":7200,
	 *         "refresh_token":"REFRESH_TOKEN", "openid":"OPENID",
	 *         "scope":"SCOPE" }
	 * @throws WeixinApiException
	 */
	public String getWebVisitorOpenIdFromBase(String code, String account) throws WeixinApiException {

		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=").append(this.appid).append("&secret=").append(this.appsecret);
		url.append("&code=").append(code).append("&grant_type=authorization_code");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				String openid = newtoken.getString("openid");
				User user = mongo.findById(openid, User.class);
				if (user == null) {
					logger.debug("create a new weixin user from web sharing");
					user = new User();
					user.setFakeid(openid);
					user.setCreatetime(new Date());
					user.setId(openid); // 使用微信的openid作为系统ID
					user.setRole(1);
					user.setSid(account);
					user.setStatus((byte) 0);
					mongo.save(user);
				}
				return openid;
			} catch (JSONException e) {
				logger.error(e.getMessage(), e);
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	/**
	 * @param code
	 * @return { "access_token":"ACCESS_TOKEN", "expires_in":7200,
	 *         "refresh_token":"REFRESH_TOKEN", "openid":"OPENID",
	 *         "scope":"SCOPE" }
	 * @throws WeixinApiException
	 */
	public String getWebVisitorOpenId(String code, String account) throws WeixinApiException {

		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=").append(this.appid).append("&secret=").append(this.appsecret);
		url.append("&code=").append(code).append("&grant_type=authorization_code");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				String openid = newtoken.getString("openid");
				User user = mongo.findById(openid, User.class);

				if (user == null) {
					logger.debug("create a new weixin user from web sharing");
					user = new User();
					user.setId(openid); // 使用微信的openid作为系统ID
					user.setCreatetime(new Date());
					user.setFakeid(openid);
					user.setRole(1);
					user.setSid(account);
					user.setStatus((byte) 0);
				}

				StringBuffer url2 = new StringBuffer();
				url2.append("https://api.weixin.qq.com/sns/userinfo?access_token=")
						.append(newtoken.getString("access_token")).append("&lang=zh_CN&openid=").append(openid);
				JSONObject wxUser = this.jsonGet(url2.toString());

				if (wxUser.has("city"))
					user.setCity(wxUser.getString("city"));
				if (wxUser.has("headimgurl"))
					user.setLogo(wxUser.getString("headimgurl"));
				if (wxUser.has("nickname"))
					user.setNickname(wxUser.getString("nickname"));
				if (wxUser.has("country"))
					user.setCountry(wxUser.getString("country"));
				if (wxUser.has("province"))
					user.setProvince(wxUser.getString("province"));
				if (wxUser.has("sex"))
					user.setSex(wxUser.getInt("sex"));
				if (wxUser.has("language"))
					user.setLanguage(wxUser.getString("language"));

				mongo.save(user);
				return openid;
			} catch (JSONException e) {
				logger.error(e.getMessage(), e);
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	/**
	 * { "openid":" OPENID", " nickname": NICKNAME, "sex":"1",
	 * "province":"PROVINCE" "city":"CITY", "country":"COUNTRY", "headimgurl":
	 * "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
	 * "privilege":[ "PRIVILEGE1" "PRIVILEGE2" ] "unionid":
	 * "o6_bmasdasdsad6_2sgVt7hMZOPfL" }
	 * 
	 * @param code
	 * @return
	 * @throws WeixinApiException
	 */
	public String getWebVisitor(String code) throws WeixinApiException {

		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=").append(this.appid).append("&secret=").append(this.appsecret);
		url.append("&code=").append(code).append("&grant_type=authorization_code");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				return newtoken.getString("openid");
			} catch (JSONException e) {
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	/**
	 * @param code
	 * @return { "access_token":"ACCESS_TOKEN", "expires_in":7200,
	 *         "refresh_token":"REFRESH_TOKEN", "openid":"OPENID",
	 *         "scope":"SCOPE" }
	 * @throws WeixinApiException
	 */
	public String getWebAccessToken(String code) throws WeixinApiException {

		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=").append(this.appid).append("&secret=").append(this.appsecret);
		url.append("&code=").append(code).append("&grant_type=authorization_code");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				return newtoken.getString("access_token");
			} catch (JSONException e) {
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	// 42002
	public String refreshOpenId(String refresh_code) throws WeixinApiException {
		// https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
		// fetch a new token
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/refresh_token?");
		url.append("appid=").append(this.appid);
		url.append("&refresh_token=").append(refresh_code).append("&grant_type=refresh_token");
		JSONObject newtoken = this.jsonGet(url.toString());
		if (newtoken.has("errcode")) {
			try {
				if ("42002".equals(newtoken.getString("errcode"))) {
					// to reauthrize
				}
			} catch (JSONException e) {
				throw new AccessTokenException("Can't get access_token".concat(e.getMessage()));
			}
		}
		if (newtoken.has("openid") && newtoken.has("refresh_token")) {
			try {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				webTokenStock.put(newtoken.getString("refresh_token"), newtoken);
				return newtoken.getString("openid");
			} catch (JSONException e) {
				throw new AccessTokenException("Can't get access_token");
			}
		} else {
			throw new AccessTokenException("Can't get access_token");
		}

		// return
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	}

	public static String getAuthorizeUrl(Setting setting, String url, SCOPE scope) {
		if (setting.getApiLevel() >= 1) {
			StringBuffer sb = new StringBuffer();
			sb.append("https://open.weixin.qq.com/connect/oauth2/authorize").append("?appid=")
					.append(setting.getAppid()).append("&redirect_uri=").append(encode(url))
					.append("&response_type=code").append("&scope=").append(scope.toString())
					.append("&state=stat1#wechat_redirect");
			return sb.toString();
		} else {
			return url;
		}
	}

	public static String getAuthorizeUrl(String appid, int apilevel, String url, SCOPE scope) {
		if (apilevel >= 1) {
			StringBuffer sb = new StringBuffer();
			sb.append("https://open.weixin.qq.com/connect/oauth2/authorize").append("?appid=").append(appid)
					.append("&redirect_uri=").append(encode(url)).append("&response_type=code")
					.append("&scope=").append(scope.toString()).append("&state=stat1#wechat_redirect");
			logger.debug("authorize url: ".concat(sb.toString()));
			return sb.toString();
		} else {
			return url;
		}
	}

	/**
	 * 主动向用户发送文本消息，而用户在24小时内有互动 {"touser":"OPENID", "msgtype":"msgtype", "text":
	 * { "content":"Hello World" }}
	 * 
	 * @param openid
	 * @param message
	 * @return
	 * @throws WeixinApiException
	 */
	public void sendTextMessage(String openid, String message) throws WeixinApiException {

		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=").append(getAccessToken());

		JSONObject reply = new JSONObject();
		try {
			reply.put("touser", openid);
			reply.put("msgtype", "text");

			JSONObject content = new JSONObject();
			content.put("message", message);
			reply.put("text", content);
		} catch (JSONException e) {
			throw new WeixinApiException(e.getMessage());
		}

		this.jsonPost(url.toString(), reply.toString());

		logger.info(reply.toString());

	}

	public void sendTemplateMessage(String openid, String templateid, Map<String, String> msgBody, String msgUrl)
			throws WeixinApiException {

		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=").append(getAccessToken());

		Map<String, Object> data = new HashMap<String, Object>();
		Iterator<String> keys = msgBody.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = msgBody.get(key);

			Map<String, String> item = new HashMap<String, String>();
			item.put("value", value);
			item.put("color", "#173177");
			data.put(key, item);
		}

		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("touser", openid);
		msg.put("template_id", templateid);
		msg.put("url", msgUrl);
		msg.put("topcolor", "#FF0000");
		msg.put("data", data);

		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(writer, msg);
		} catch (IOException e) {
			throw new WeixinApiException(e.fillInStackTrace());
		}
		logger.debug(writer.toString());
		this.jsonPost(url.toString(), writer.toString());

	}

	public void sendTemplateMessageWithColor(String openid, String templateid, Map<String, String> msgBody,
			Map<String, String> colors, String msgUrl) throws WeixinApiException {
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=").append(getAccessToken());

		Map<String, Object> data = new HashMap<String, Object>();
		Iterator<String> keys = msgBody.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			String value = msgBody.get(key);

			Map<String, String> item = new HashMap<String, String>();
			item.put("value", value);
			item.put("color", "#173177");
			if (colors != null && !StringUtil.isEmpty(colors.get(key)))
				item.put("color", colors.get(key));

			data.put(key, item);
		}

		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("touser", openid);
		msg.put("template_id", templateid);
		msg.put("url", msgUrl);
		msg.put("topcolor", "#FF0000");
		if (colors != null && !StringUtil.isEmpty(colors.get("topcolor")))
			msg.put("topcolor", colors.get("topcolor"));

		msg.put("data", data);

		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(writer, msg);
		} catch (IOException e) {
			throw new WeixinApiException(e.fillInStackTrace());
		}
		logger.debug(writer.toString());
		this.jsonPost(url.toString(), writer.toString());
	}

	/**
	 * 主动向用户发送图文消息，而用户在24小时内有互动
	 * 
	 * @param openid
	 * @param news
	 * @throws WeixinApiException
	 */
	public void sendNewsMessage(String openid, List<News> news) throws WeixinApiException {
		//
		// if(mongo!=null){
		// //检查用户互动时间是否在规定的时间内
		// Query query = new Query(Criteria.where("fakeid").is( openid ));
		// User receiver = mongo.findOne(query, User.class );
		// if( receiver != null && receiver.getSignindate()!=null ){
		// Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.HOUR_OF_DAY, -48 );
		// if( receiver.getSignindate().before( cal.getTime() )) {
		// logger.debug(new
		// StringBuffer().append(receiver.getNickname()).append("签到超时了！").append(receiver.getSignindate()).toString());
		// return;
		// }
		//
		// }else{
		// return;
		// }
		// }

		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=").append(getAccessToken());

		JSONObject reply = new JSONObject();
		try {
			reply.put("touser", openid);
			reply.put("msgtype", "news");

			JSONArray articles = new JSONArray();
			for (News n : news) {
				JSONObject obj = new JSONObject();
				obj.put("title", n.getTitle());
				obj.put("description", n.getDescription());
				obj.put("url", n.getUrl());
				obj.put("picurl", n.getPicUrl());
				articles.put(obj);
			}
			JSONObject j = new JSONObject();
			j.put("articles", articles);
			reply.put("news", j);

			logger.info(reply.toString());

		} catch (JSONException e) {
			e.printStackTrace();
			throw new WeixinApiException(e.getMessage());
		}

		this.jsonPost(url.toString(), reply.toString());

	}

	public String download(String account, String mediaid) {

		try {

			StringBuffer url = new StringBuffer("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=");
			url.append(this.getAccessToken()).append("&media_id=").append(mediaid);

			HttpClient httpClient = new HttpClient(); // for port 80 requests!

			GetMethod getMethod = new GetMethod(url.toString());

			httpClient.executeMethod(getMethod);

			FileStorage storage = new FileStorage();
			Header header = getMethod.getResponseHeader("content-type");
			String path = storage.save(getMethod.getResponseBody(), account, "media", mediaid,
					header == null ? "" : header.getValue());

			return path;

		} catch (Throwable e) {
			logger.error("===========================");
			logger.error("error in fetch meida:".concat(mediaid));
			logger.error(e.getMessage());
			logger.error("===========================");
		}
		return null;
	}

	/**
	 * 微信卡券授权的config方法。该方法缓存卡券Ticket，过期后自动更新
	 * 
	 * @param url
	 * @return
	 * @throws WeixinApiException
	 */
	public String getCardToken() throws WeixinApiException {
		try {
			JSONObject access_token = cardTokenStock.get(appid);
			if (access_token != null && access_token.has("expires")
					&& access_token.getLong("expires") > System.currentTimeMillis()) {
				return access_token.getString("ticket");
			}

			StringBuffer jsUrl = new StringBuffer(
					"https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=wx_card&access_token=")
							.append(this.getAccessToken());
			JSONObject newtoken = jsonGet(jsUrl.toString());
			;
			if (newtoken.has("expires_in") && newtoken.getInt("expires_in") > 0) {
				newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
				cardTokenStock.put(this.appid, newtoken);
				return newtoken.getString("ticket");
			}

			throw new AccessTokenException("Can't get card_api_ticket");
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 微信JS接口授权的config方法。该方法自动缓存上次的JSTicket，过期后自动更新.
	 * 
	 * @param url
	 *            当前访问地址
	 * @return
	 * @throws WeixinApiException
	 */
	public Map<String, String> wxConfig(String url) throws WeixinApiException {

		Map<String, String> ret = new HashMap<String, String>();
		String jsapi_ticket = null;
		String nonce_str = null;
		String timestamp = null;
		StringBuffer string1 = new StringBuffer();
		String signature = "";

		try {
			JSONObject access_token = jsTokenStock.get(appid);
			if (access_token != null && access_token.has("expires")
					&& access_token.getLong("expires") > System.currentTimeMillis()) {
				jsapi_ticket = access_token.getString("ticket");
				timestamp = access_token.getString("timestamp");
				nonce_str = access_token.getString("nonce_str");
			} else {
				StringBuffer jsUrl = new StringBuffer()
						.append("https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=")
						.append(this.getAccessToken());

				JSONObject newtoken = jsonGet(jsUrl.toString());
				;
				if (newtoken.has("expires_in") && newtoken.getInt("expires_in") > 0) {
					newtoken.put("expires", System.currentTimeMillis() + newtoken.getLong("expires_in") * 1000 - 5);
					timestamp = String.valueOf(System.currentTimeMillis() / 1000);
					nonce_str = UUID.randomUUID().toString();
					newtoken.put("timestamp", timestamp);
					newtoken.put("nonce_str", nonce_str);
					jsTokenStock.put(this.appid, newtoken);
					jsapi_ticket = newtoken.getString("ticket");

				} else {
					throw new AccessTokenException("Can't get access_token");
				}
			}
		} catch (JSONException e) {
			throw new AccessTokenException(e);
		}

		// 注意这里参数名必须全部小写，且必须有序
		string1.append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(nonce_str)
				.append("&timestamp=").append(timestamp).append("&url=").append(url);

		signature = SHA1.encrypt(string1.toString());

		if (logger.isDebugEnabled())
			logger.debug("weixin jsapi config [" + string1.append("&signature=").append(signature).append("]"));

		ret.put("appid", this.appid);
		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	public Map<String, String> wxPay(String packages, String paySignKey) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("appId", this.appid);
		params.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
		params.put("nonceStr", MD5.encode(packages));
		params.put("package", packages);
		params.put("signType", "MD5");

		List<Map.Entry<String, String>> keys = new ArrayList<Map.Entry<String, String>>(params.entrySet());
		// 排序
		Collections.sort(keys, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		// 排序后
		StringBuffer raw = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			Entry<String, String> entry = keys.get(i);
			if (entry.getValue() == null)
				continue;
			if (i > 0)
				raw.append("&");
			raw.append(entry.getKey()).append("=").append(entry.getValue());
		}
		raw.append("&key=").append(paySignKey);
		logger.debug(raw.toString());

		String signature = MD5.encode(raw.toString());
		if (logger.isDebugEnabled())
			logger.debug("paySign: [" + signature + "]");
		params.put("paySign", signature);
		params.put("timestamp", params.get("timeStamp"));
		// 去掉无用参数，用于JS调用微信支付，以防止对签名产生干扰
		params.remove("timeStamp");
		params.remove("appId");

		logger.debug(params.toString());

		return params;
	}

	public XMLReturn wxUnifiedOrder() {

		return null;
	}

	/**
	 * 调用微信商户号，执行企业付款功能，向个人微信号付款
	 * 
	 * @param xml
	 * @return
	 * @throws WeixinApiException
	 */
	public XMLReturn payToWeixinUser(String xml) throws WeixinApiException {
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
		logger.debug(xml);

		XMLReturn ret = xmlPostWithCert(url, xml);
		if (logger.isDebugEnabled()) {
			logger.debug("Pay To Weixin User: [" + ret.getReturnCode() + ":" + ret.getReturnMsg() + ":"
					+ ret.getResultCode() + "]");
		}

		return ret;
	}

	/**
	 * 向个人发放微信企业红包
	 * 
	 * @param xml
	 * @return
	 * @throws WeixinApiException
	 */
	public XMLReturn sendRedPackToUser(String xml) throws WeixinApiException {
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
		logger.debug(xml);

		XMLReturn ret = xmlPostWithCert(url, xml);
		if (logger.isDebugEnabled()) {
			logger.debug("Send Red Pack To User: [" + ret.getReturnCode() + ":" + ret.getReturnMsg() + ":"
					+ ret.getResultCode() + "]");
		}

		return ret;
	}

	protected CloseableHttpClient getHttpClientWithCert() throws WeixinApiException {
		String certFilePath = Config.TENPAY_PARTNER_CERT_PATH;
		String key = Config.TENPAY_PARTNER_CERT_KEY;

		FileInputStream is = null;
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			is = new FileInputStream(new File(certFilePath));
			keyStore.load(is, key.toCharArray());

			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, key.toCharArray()).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeixinApiException("Create Http Client With Certificate Failed!");
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}

	protected XMLReturn xmlGetWithCert(String url) throws WeixinApiException {
		CloseableHttpClient client = getHttpClientWithCert();

		CloseableHttpResponse response = null;
		try {
			HttpGet httpget = new HttpGet(url);
			response = client.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				StringBuffer sb = new StringBuffer();
				String text;
				while ((text = bufferedReader.readLine()) != null) {
					sb.append(text);
				}
				EntityUtils.consume(entity);

				logger.debug(sb.toString());
				return toXMLReturn(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeixinApiException("XML Get With Certificate Failed!");
		} finally {
			try {
				response.close();
			} catch (IOException e) {
			}
			try {
				client.close();
			} catch (IOException e) {
			}
		}

		return null;
	}

	protected XMLReturn xmlPostWithCert(String url, String xml) throws WeixinApiException {
		CloseableHttpClient client = getHttpClientWithCert();

		CloseableHttpResponse response = null;
		try {
			HttpPost httppost = new HttpPost(url);
			httppost.addHeader("Content-Type", "text/xml");
			StringEntity xmlEntity = new StringEntity(xml, "UTF-8");
			httppost.setEntity(xmlEntity);

			response = client.execute(httppost);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				StringBuffer sb = new StringBuffer();
				String text;
				while ((text = bufferedReader.readLine()) != null) {
					sb.append(text);
				}
				EntityUtils.consume(entity);

				logger.debug(sb.toString());
				return toXMLReturn(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeixinApiException("XML POST With Certificate Failed!");
		} finally {
			try {
				response.close();
			} catch (IOException e) {
			}
			try {
				client.close();
			} catch (IOException e) {
			}
		}

		return null;
	}

	protected XMLReturn toXMLReturn(String s) throws WeixinApiException {
		try {
			JAXBContext context = JAXBContext.newInstance(XMLReturn.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (XMLReturn) unmarshaller.unmarshal(new StringReader(s));
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WeixinApiException("Tranform String To XMLReturn Failed!");
		}
	}

	/** 申请摇周边设备 */
	public JSONObject applyYaoDevice(String data) throws WeixinApiException {
		String url = "https://api.weixin.qq.com/shakearound/device/applyid?access_token=" + getAccessToken();
		return jsonPost(url, data);
	}

	/** 刷新摇周边设备数据 */
	public JSONObject refreshDeviceStatus(String data) throws WeixinApiException {
		String url = "https://api.weixin.qq.com/shakearound/device/search?access_token=" + getAccessToken();
		return jsonPost(url, data);
	}

	/** 创建摇周边页面 */
	public JSONObject createYaoPage(String data) throws WeixinApiException {
		String url = "https://api.weixin.qq.com/shakearound/page/add?access_token=" + getAccessToken();
		return jsonPost(url, data);
	}

	/** 编辑摇周边页面 */
	public JSONObject updateYaoPage(String data) throws WeixinApiException {
		String url = "https://api.weixin.qq.com/shakearound/page/update?access_token=" + getAccessToken();
		return jsonPost(url, data);
	}

	/** 上传摇周边相关图片素材 */
	public JSONObject uploadYaoPic(String filePath) throws WeixinApiException {
		String url = "https://api.weixin.qq.com/shakearound/material/add?access_token=" + getAccessToken();
		String ret = uploadFile(url, filePath);

		try {
			return new JSONObject(ret);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new WeixinApiException("文件上传出错:" + filePath);
		}
	}

	/** 向摇周边设备配置页面 */
	protected boolean bindPageToDevice(Integer deviceId, List<Integer> pageIds, boolean forAdd) {
		try {
			String url = "https://api.weixin.qq.com/shakearound/device/bindpage?access_token=" + getAccessToken();

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("page_ids", pageIds);
			data.put("bind", forAdd ? 1 : 0);
			data.put("append", 1);
			Map<String, Integer> deviceIdentifier = new HashMap<String, Integer>();
			deviceIdentifier.put("device_id", deviceId);
			data.put("device_identifier", deviceIdentifier);

			String sData = JsonUtil.toJSONString(data);

			JSONObject ret = jsonPost(url, sData);
			if (ret.getInt("errcode") == 0)
				return true;
		} catch (WeixinApiException | JSONException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	/** 添加页面 */
	public boolean addPageToDevice(Integer deviceId, List<Integer> pageIds) {
		return bindPageToDevice(deviceId, pageIds, true);
	}

	/** 删除页面 */
	public boolean removePageFromDevice(Integer deviceId, List<Integer> pageIds) {
		return bindPageToDevice(deviceId, pageIds, false);
	}

	/** 上传文件 */
	public String uploadFile(String urls, String filePath) throws WeixinApiException {
		// 初始化https协议
		this.prepareForHttps();

		String res = "";
		HttpURLConnection conn = null;
		String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
		try {
			URL url = new URL(urls);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			OutputStream out = new DataOutputStream(conn.getOutputStream());

			File file = new File(filePath);
			String filename = file.getName();
			String contentType = new MimetypesFileTypeMap().getContentType(file);
			if (filename.endsWith(".png")) {
				contentType = "image/png";
			}
			if (contentType == null || contentType.equals("")) {
				contentType = "application/octet-stream";
			}

			StringBuffer strBuf = new StringBuffer();
			strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
			strBuf.append("Content-Disposition: form-data; filename=\"" + filename + "\"\r\n");
			strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

			out.write(strBuf.toString().getBytes());

			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();

			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();

			// 读取返回数据
			StringBuffer strBuf2 = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuf2.append(line).append("\n");
			}
			res = strBuf2.toString();
			reader.close();
			reader = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeixinApiException("文件上传出错:" + urls);
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		logger.debug(res);
		return res;
	}

	/** 初始化HTTPS协议 */
	private void prepareForHttps() throws WeixinApiException {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeixinApiException("微信API错误，初始化HTTPS失败！");
		}
	}

	/** 以下为门店相关接口 */
	/** 查询门店列表 */
	public JSONObject getPoiList(String data) throws WeixinApiException {
		String url = "http://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=" + getAccessToken();
		return jsonPost(url, data);
	}

	private static String encode(String param) {
		String charset="utf-8";
		try {
			return URLEncoder.encode(param,charset);
		} catch (UnsupportedEncodingException e) {
			return null;
		}

	}

	/*
	 * public String packages( Order order, String partnerid, String partnerKey,
	 * String userIP) {
	 * 
	 * NumberFormat f = NumberFormat.getIntegerInstance(); f.setGroupingUsed(
	 * false ); SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	 * Calendar orderDate = Calendar.getInstance(); orderDate.setTime(
	 * order.getCreateDate() );
	 * 
	 * Map<String, String> params = new HashMap<String, String>();
	 * params.put("bank_type", "WX"); params.put("mch_id", "10019105");
	 * params.put("body", "订单号：".concat(order.getCode()) );
	 * //params.put("attach", "idaka"); params.put("partner", partnerid);
	 * params.put("out_trade_no", order.getId()); params.put("total_fee",
	 * f.format(order.getTotal()*100)); //单位：分 params.put("fee_type", "1");
	 * params.put("notify_url", Config.WEIXIN_NOTIFY_URL );
	 * params.put("spbill_create_ip", userIP); params.put("time_start",
	 * fmt.format(orderDate.getTime())); orderDate.add(Calendar.HOUR, 2 );
	 * params.put("time_expire", fmt.format(orderDate.getTime()));
	 * params.put("transport_fee", "0"); params.put("product_fee",
	 * f.format(order.getTotal()*100)); //单位：分 params.put("goods_tag", null);
	 * params.put("input_charset", "UTF-8");
	 * 
	 * List<Map.Entry<String, String>> keys = new ArrayList<Map.Entry<String,
	 * String>>(params.entrySet()); //排序 Collections.sort(keys, new
	 * Comparator<Map.Entry<String, String>>() { public int
	 * compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
	 * return o1.getKey().compareTo(o2.getKey()); } }); //排序后 StringBuffer raw =
	 * new StringBuffer(); for (int i = 0; i < keys.size(); i++) { Entry<String,
	 * String> entry = keys.get(i); if(entry.getValue()==null) continue; if(i>0)
	 * raw.append("&");
	 * raw.append(entry.getKey()).append("=").append(entry.getValue()); }
	 * logger.debug( raw.toString() );
	 * 
	 * String packages = new URLEncoder().encode(raw.toString()); String sign =
	 * MD5.encode( raw.append("&key=").append(partnerKey).toString()
	 * ).toUpperCase();
	 * 
	 * packages.concat("&sign=").concat(sign);
	 * 
	 * return packages ; }
	 */
}