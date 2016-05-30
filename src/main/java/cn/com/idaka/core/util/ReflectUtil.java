package cn.com.idaka.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public class ReflectUtil {

	public static Object getProperty(Object obj, Object key) {
		if ((obj == null) || (key == null)) {
			return null;
		}

		if ((obj instanceof Map)) {
			return ((Map<?, ?>) obj).get(key);
		}

		Method method = getReadMethod(obj.getClass(), key.toString());
		if (method == null)
			throw new RuntimeException("lang.err_unknown_property:"+key);

		return invokeExactMethod(method, obj, new Object[0]);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setProperty(Object obj, Object key, Object value) {
		if ((obj == null) || (key == null)) {
			return;
		}

		if ((obj instanceof Map)) {
			((Map) obj).put(key, value);
			return;
		}

		Method method = getWriteMethod(obj.getClass(), key.toString());
		if (method == null)
			throw new RuntimeException("lang.err_unknown_property");

		invokeExactMethod(method, obj, new Object[] { value });
	}

	public static Method getReadMethod(Class<?> clazz, String propName) {
		String prop = StringUtil.capitalize(propName);
		for (Method method : clazz.getMethods())
			if (Modifier.isPublic(method.getModifiers())) {
				if (method.getParameterTypes().length == 0) {
					String methodName = method.getName();
					if (methodName.equals("get" + prop)) {
						return method;
					}
					if ((methodName.equals("is" + prop)) && (method.getReturnType() == Boolean.TYPE))
						return method;
				}
			}
		return null;
	}

	public static Method getWriteMethod(Class<?> clazz, String propName) {
		String prop = StringUtil.capitalize(propName);
		String setName = "set" + prop;
		for (Method method : clazz.getMethods()) {
			if (Modifier.isPublic(method.getModifiers())) {
				if ((method.getParameterTypes().length == 1) && (method.getName().equals(setName)))
					return method;
			}
		}
		return null;
	}

	public static Object invokeExactMethod(Method method, Object o,	Object[] args) {
		try {
			method.setAccessible(true);
			return method.invoke(o, args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static Object getFieldValue(Class<?> clazz, String key){
		if(clazz == null || key == null)
			return null;
		
		try{
			Field field = clazz.getDeclaredField(key);
			if(field != null)
				return field.get(clazz);
		}catch(NoSuchFieldException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
		return null;
	}

}