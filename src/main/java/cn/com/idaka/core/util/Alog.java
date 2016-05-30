package cn.com.idaka.core.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合算法帮助类，用于处理关于集合和数学算法的常见问题
 * @author madongdong
 *
 */
public class Alog{

	public static <T> List<T> subList(List<T> list, int from, int to){
		if(list == null || list.isEmpty())
			return null;
		
		int n = list.size();
		if(from >= n)
			return null;
		
		if(from < 0)
			from = 0;
		
		if(to > n)
			to = n;
		
		return list.subList(from, to);
	}
	
	/**
	 * 根据字段名和值对集合进行过滤，返回符合条件的第一个元素
	 * @param c
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T findOne(Collection<?> c, String key, Object value){
		if(c == null)
			return null;
		
		for(Object o : c){
			Object v = ReflectUtil.getProperty(o, key);
			if(value == null && v == null)
				return (T)o;
			if(value != null && value.equals(v))
				return (T)o;
		}
		
		return null;
	}
	
	/**
	 * 根据字段名和值对集合进行过滤，返回符合条件的元素组成的新集合
	 * @param c
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> findMany(Collection<?> c, String key, Object value){
		if(c == null)
			return null;
		
		List<Object> ret = new ArrayList<Object>();
		for(Object o : c){
			Object v = ReflectUtil.getProperty(o, key);
			if(value == null && v == null)
				ret.add(o);
			if(value != null && value.equals(v))
				ret.add(o);
		}
		
		return (List<T>)ret;
	}
	
	/**
	 * 读取集合中所有元素的其中一列，返回该列数据组成的新集合
	 * @param c
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> pluck(Collection<?> c, String key){
		if(c == null)
			return null;
		
		List<Object> ret = new ArrayList<Object>(c.size());
		for(Object o : c){
			ret.add(ReflectUtil.getProperty(o, key));
		}
		
		return (List<T>)ret;
	}
	
	public static Double sum(Collection<?> c){
		if(c == null)
			return null;
		
		double sum = 0.0D;
		for(Object o : c){
			Double v = Double.parseDouble(String.valueOf(o));
			sum += v.doubleValue();
		}
		
		return sum;
	}
	
	/**
	 * 对集合的集合进行扁平化操作，返回所有元素组成的一维集合
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> flatten(Collection<?> c){
		if(c == null)
			return null;
		
		List<Object> ret = new ArrayList<Object>();
		for(Object o : c){
			if(o instanceof Collection)
				ret.addAll((Collection<?>)o);
			else
				ret.add(o);
		}
		
		return (List<T>)ret;
	}
	
	/**
	 * 对集合进行分组，按指定字段的值相同的元素合并到一组
	 * @throws  
	 * @throws NoSuchFieldException 
	 * */
	@SuppressWarnings("unchecked")
	public static <T> Map<Object,List<T>> group(Collection<?> c, String key){
		if(c == null)
			return null;
		Map<Object, List<T>> ret = new HashMap<Object, List<T>>();
		for(Object o : c){
			Object value= ReflectUtil.getProperty(o, key);
			if(null!=value){
				if(ret.get(value)==null){
					List<T> list=new ArrayList<T>();
					list.add((T)o);
					ret.put(value, list);
				}else{
					List<T> list=ret.get(value);
					list.add((T)o);
				}
			}
		}
		
		return ret;
	}
	
	/** 对集合按指定字段进行升序排序 */
	public static <T> List<T> sortByFld(Collection<?> c, final String key) {
		return sortByFld(c,key,true);
	}
	
	/** 对集合 按指定的字段指定顺序排序 */
	public static <T> List<T> sortByFld(Collection<?> c, final String key, final boolean asc) {
		final List<String> keys = Arrays.asList(new String[]{key});
		return sortByFld(c, keys, asc);
	}
	
	/**
	 * 对集合按指定字段进行排序
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> sortByFld(Collection<?> c, final List<String> keys, final boolean asc) {
		if (c == null)
			return null;

		List<Object> list = new ArrayList<Object>(c);
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				int ret = 0;
				if (o1 == o2)
					ret = 0;
				else if (o1 == null)
					ret = -1;
				else if (o2 == null)
					ret = 1;
				else if (o1.equals(o2))
					ret = 0;
				else {
					for(String key : keys){
						Object v1 = ReflectUtil.getProperty(o1, key);
						Object v2 = ReflectUtil.getProperty(o2, key);
						if (v1 == v2) {
							ret = 0;
						} else if (v1 == null) {
							ret = -1;
						} else if (v2 == null) {
							ret = 1;
						} else if(v1.equals(v2)){
							ret = 0;
						} else if((v1 instanceof Number) && (v2 instanceof Number)){
				            ret = ((Number)v1).doubleValue() <= ((Number)v2).doubleValue() ? -1 : 1;
						} else if(v1 instanceof Comparable){
				            ret = ((Comparable)v1).compareTo(v2);
						} else{
							int i = v1.hashCode();
							int j = v2.hashCode();
							if (i == j)
								ret = 0;
							else
								ret = i >= j ? 1 : -1;
						}
						
						if(ret != 0)
							return asc ? ret : -ret;
					}
				}
				
				return asc ? ret : -ret;
			}
		});

		return (List<T>) list;
	}
	
}