package cn.com.idaka.core.helper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import cn.com.idaka.core.util.BeanLoader;

@Service
public class AsyncTaskHelper {
	
	ExecutorService executor = Executors.newFixedThreadPool(5);  
	
	public static AsyncTaskHelper getInstance(){
		return (AsyncTaskHelper)BeanLoader.getBean(AsyncTaskHelper.class);
	}
	
	public void execute(Runnable task){
		try{
			executor.execute(task);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
