package cn.com.idaka.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class BeanLoader implements ApplicationContextAware {
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		context = ac;
	}
	
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
	public static Object getBean(Class<?> clazz) {
		return getBean(guessName(clazz));
	}

	static String guessName(Class<?> clazz) {
		String name = clazz.getName();
		int pos = name.lastIndexOf('.');
		if (pos > 0)
			name = name.substring(pos + 1);
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

}
