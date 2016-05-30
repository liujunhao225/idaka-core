package cn.com.idaka.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MD5 {
	
	/**
	 * 将字符串通过MD5加密
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		try{
			byte[] strByte = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(strByte);
			byte[] newByte = md.digest();
			
			// 转换为16进制
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < newByte.length; i++) {
				if ((newByte[i] & 0xff) < 0x10) {
					sb.append("0");
				}
				sb.append(Long.toString(newByte[i] & 0xff, 16));
			}
			return sb.toString().toUpperCase();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 对键值对进行排序拼接，最后加入key之后，再进行md5加密，符合微信常用的md5加密方式
	 * @param params
	 * @param key
	 * @return
	 */
	public static String encode(Map<String,Object> params, String key){
		List<Entry<String, Object>> keys = new ArrayList<Entry<String, Object>>(params.entrySet()); 	
    	//排序
    	Collections.sort(keys, new Comparator<Entry<String, Object>>() {
    	    public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {      
    	        return o1.getKey().compareTo(o2.getKey());
    	    }
    	}); 
		
    	StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			Entry<String, Object> entry = keys.get(i);
			if (entry.getValue() == null)
				continue;
			if (sb.length() > 0)
				sb.append("&");
			sb.append(entry.getKey()).append("=").append(entry.getValue());
		}
		sb.append("&key=").append(key);
		
    	return MD5.encode(sb.toString());
	}
	
}