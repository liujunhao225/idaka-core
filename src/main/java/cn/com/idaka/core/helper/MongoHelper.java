package cn.com.idaka.core.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import cn.com.idaka.core.util.BeanLoader;

@Service
public class MongoHelper {
	
	@Autowired
	protected MongoTemplate mongo;

	public static MongoHelper getInstance(){
		return (MongoHelper)BeanLoader.getBean(MongoHelper.class);
	}
	
	public static MongoTemplate getMongo(){
		return getInstance().mongo;
	}
	
	public static <T> T findById(Object id, Class<T> clazz){
		return getMongo().findById(id, clazz);
	}
}
