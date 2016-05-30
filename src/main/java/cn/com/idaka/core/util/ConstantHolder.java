package cn.com.idaka.core.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ConstantHolder implements Map<Object, Object>{
	
	private Class<?> constClass = null;
	
	public ConstantHolder(Class<?> clazz){
		this.constClass = clazz;
	}
	
	public Object get(Object key){
		if(constClass == null || key == null)
			return null;
		String sKey = key.toString();
		
		Class<?> innerClass = this.getInnerClass(sKey);
		if(innerClass != null)
			return new ConstantHolder(innerClass);
		
		return ReflectUtil.getFieldValue(constClass, sKey);
	}
	
	private Class<?> getInnerClass(String name){
		Class<?>[] classes = constClass.getDeclaredClasses();
		if(classes == null || classes.length == 0)
			return null;
		
		int i = 0, n = classes.length;
		for(; i < n; i++){
			Class<?> innerClass = classes[i];
			if(innerClass.getName().endsWith("$"+name))
				return innerClass;
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public void clear() {
	}

	@Override
	public boolean containsKey(Object arg0) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Set entrySet() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Set keySet() {
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		return null;
	}

	@Override
	public void putAll(Map m) {
		
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection values() {
		return null;
	}
	
}
