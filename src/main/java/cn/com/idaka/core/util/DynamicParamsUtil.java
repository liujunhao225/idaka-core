package cn.com.idaka.core.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.ui.ModelMap;

public class DynamicParamsUtil {
	
	/**
	 * 根据查询form构建{@link Criteria},字符类型默认是模糊查询，数字和日期为“等于”,用字段名“beginDate”和“endDate”表示"date"的查询区间。
	 * @param sid 当前账号
	 * @param form 查询form
	 * @return
	 */
	public static Criteria buildCriteria(String sid, Object form){

		try{			
			Field[] fields = form.getClass().getDeclaredFields();
			Criteria c = Criteria.where("sid").is(sid);
			for (Field field : fields) {
				field.setAccessible(true);
				addValue(field, form, c);
			}
			
			return c;
		}catch(IllegalAccessException e){
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected static void addValue(Field field, Object form, Criteria c) throws IllegalArgumentException, IllegalAccessException, UnsupportedEncodingException{
		if(field.getType().isAssignableFrom( Integer.TYPE )){
			if(field.getInt( form )>0){
				c.and(field.getName()).is( field.getInt( form ) );
			}
		}else if(field.getType().isAssignableFrom( String.class ) && field.get( form )!=null ){
			String value = URLDecoder.decode((String)field.get( form ),"utf-8");
			if(value == null || "".equals(value) || "none".equals(value)) return;
			field.set( form , value);
			
			value = value.replace("*", "\\*");
			c.and(field.getName()).regex( value );
		}else if(field.getType().isAssignableFrom( Date.class ) && field.get( form )!=null ){
			if(field.getName().startsWith("begin")){
				c.and(field.getName().substring(5).toLowerCase()).gt( field.get( form ) );
			}else if(field.getName().endsWith("end")){
				c.and(field.getName().substring(3).toLowerCase()).lt( field.get( form ) );
			}else{
				c.and(field.getName()).is( field.get( form ) );
			}
		}else if(field.getType().isAssignableFrom( Float.class ) && field.get( form )!=null ){
			if(field.getName().startsWith("begin")){
				c.and(field.getName().substring(5).toLowerCase()).gt( field.get( form ) );
			}else if(field.getName().endsWith("end")){
				c.and(field.getName().substring(3).toLowerCase()).lt( field.get( form ) );
			}else{
				c.and(field.getName()).is( field.get( form ) );
			}
		}else if(field.getType().isAssignableFrom( Double.class ) && field.get( form )!=null ){
			c.and(field.getName()).is( field.get( form ) );
		}
	}

	/**
	 * 附加动态查询条件组合及返回参数显示.
	 * 示例：actived:int,qrcode:int,driver::,plateNumber::,mobile,withdraw:double
	 * 说明：多个参数以半角逗号分隔，每个参数包含参数名、参数类型、是否模糊查询，后两个属性非必须，参数类型默认字符型，默认非模糊查询，当参数是double类型时，查询使用大于等于
	 */
	public static void appendCriteriaAndAddAttribute(ModelMap model, Criteria criteria, HttpServletRequest request,
			String paramsString) {
		Map<String, Object> params = getRequestParametersMap(request, paramsString);
		for (String keyObj : params.keySet()) {
			String[] keys = keyObj.split(":", -1);
			String key = keys[0];
			Object val = params.get(keyObj);
			if (val != null && val.toString().trim().length() != 0) {
				if (keys.length == 1) {
					criteria = criteria.and(key).is(val.toString().trim());
				} else if (keys.length == 2 && keys[1].equals("int")) {
					criteria = criteria.and(key).is(Integer.parseInt(val.toString().trim()));
				} else if (keys.length == 2 && keys[1].equals("double")) {
					criteria = criteria.and(key).gte(Double.parseDouble(val.toString().trim()));
				} else if (keys.length == 2 && keys[1].equals("regex")) {
					criteria = criteria.and("$where").is("/^" + val.toString().trim() +"$/.test(this." + key + ")");
				} else if (keys.length == 3) {
					criteria = criteria.and(key).regex(".*" + val.toString().trim() + ".*");
				}
			}
			model.addAttribute(key, val);
		}
	}
	
	/**
	* 获取request里的参数封装成map，如果是get请求则全部解码一次，post请求不解码.
	*
	* @param request HttpServletRequest
	* @param params 参数串"a:type,b"，类型暂只有int，不区分的就是String
	* @return
	*/
	public static Map<String, Object> getRequestParametersMap(HttpServletRequest request, String params) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String[] paramsArr = params.split(",");
		for (String param : paramsArr) {
			String value = request.getParameter(param.split(":")[0]);
			if ("get".equalsIgnoreCase(request.getMethod())) {
				try {
					if (value != null) {
						value = URLDecoder.decode(value, "UTF-8");
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			paramsMap.put(param, value);
		}
		return paramsMap;
	}
	
	public static String ticketGenerator(String prefix, int salt){
		String raw = MD5.encode(new StringBuffer().append(System.currentTimeMillis()).append(salt).toString());
		StringBuffer code = new StringBuffer();
		code.append( prefix ).append("-")
		.append(raw.substring(3, 7)).append("-")
		.append(raw.substring(9, 13)).append("-")
		.append(raw.substring(14,18)).append("-")
		.append(raw.substring(20,24));
		return code.toString();
	}
}
