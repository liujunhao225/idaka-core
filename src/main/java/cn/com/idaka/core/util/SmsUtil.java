package cn.com.idaka.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 短信发送工具类.
 */
public class SmsUtil {

	private static Logger log = LoggerFactory.getLogger(SmsUtil.class);

	public static void main(String[] args) {
		String msg = "测试啊哈哈哈哈哈哈昏昏浩浩昏昏浩浩昏昏浩浩昏昏浩浩哈哈哈222222223333333" + new Date();
		sendMessage("http://221.131.70.235:8181/ets/order/sendGroupMsg.do", "13815862735", msg);
	}

	/**
	 * 发送消息.
	 * 
	 * @param serverUrl 发送短信URL
	 * @param groupPhones 手机号码之间用英文逗号“,”隔开
	 * @param groupMsg 短信内容
	 */
	public static int sendMessage(String serverUrl, String groupPhones, String groupMsg) {
		serverUrl = serverUrl == null ? "" : serverUrl.trim();
		int statusCode = 0;

		try {
			groupMsg = URLEncoder.encode(groupMsg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("", e);
		}

		GetMethod method = new GetMethod(serverUrl + "?groupPhones=" + groupPhones + "&groupMsg=" + groupMsg);

		log.info("SendMessage start.");
		try {
			HttpClient httpClient = new HttpClient();
			statusCode = httpClient.executeMethod(method);
			String soapResponseData = method.getResponseBodyAsString();

			log.info("SendMessage end. statusCode: " + statusCode);
			log.info("SendMessage end. soapResponseData: " + soapResponseData);
		} catch (Exception e) {
			log.error("", e);
		}

		log.info("SendMessage end.");
		return statusCode;
	}

}
