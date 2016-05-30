package cn.com.idaka.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GEOUtil {
	
	public static Logger logger = LoggerFactory.getLogger(GEOUtil.class);
	public static final String KEY_1 = "7d9fbeb43e975cd1e9477a7e5d5e192a";
	
	/**
	 * 返回输入地址的经纬度坐标
	 * @return [lng(经度),lat(纬度)]
	 */
	public static Float[] getGeocoderLatitude(String address){
		BufferedReader in = null;
		try {
			//将地址转换成utf-8的16进制
			address = URLEncoder.encode(address, "UTF-8");
			URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+ KEY_1);
			
			in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));
			String res;
			StringBuilder sb = new StringBuilder();
			while((res = in.readLine())!=null){
				sb.append(res.trim());
			}

			JSONObject baidu = new JSONObject(sb.toString());
			if(logger.isDebugEnabled()){
				logger.debug(baidu.toString());
			}
			if(baidu.has("result")){
				JSONObject location = baidu.getJSONObject("result").getJSONObject("location");
				Float[] geo = new Float[2];
				geo[0] = new Float(location.getDouble("lng"));
				geo[1] = new Float(location.getDouble("lat"));
				return geo;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String args[]){
		GEOUtil.getGeocoderLatitude("北京亮马桥");
	}
}
