package cn.com.idaka.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import cn.com.idaka.core.helper.MongoHelper;


/**
 * 时间帮助类
 * @author madongdong
 *
 */
public class DateUtil{

	/**
	 * 获取下一个星期一
	 * @param date
	 * @return
	 */
	public static Date getNextMonday(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int i = c.get(Calendar.DAY_OF_WEEK);
		if(i == 1){ //星期天
			c.add(Calendar.DAY_OF_MONTH, 1);
		}else{		//星期一~六
			c.add(Calendar.DAY_OF_MONTH, 7-i+2);
		}
		
		return c.getTime();
	}
	
	/**
	 * 获取下一个星期五
	 * @param date
	 * @return
	 */
	public static Date getNextFriday(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int i = c.get(Calendar.DAY_OF_WEEK);
		if(i == 1){ //星期天
			c.add(Calendar.DAY_OF_MONTH, 5);
		}else{		//星期一~六
			c.add(Calendar.DAY_OF_MONTH, 7+(6-i));
		}
		
		return c.getTime();
	}
	
	/**
	 * 获取下个月1号
	 * @param date
	 * @return
	 */
	public static Date getNextMonthFirstDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }
	
	public static Date toEndOfDay(Date date){
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(date) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 2015-11-06 新增 by chentao
	 * 丰富DateUtil 功能
	 */
	public static String defaultSimpleFormater = "yyyy-MM-dd hh:mm:ss";  
	
	public static String defaultDateFormater ="yyyy-MM-dd";
	/** 
	* 默认简单日期字符串 
	*  
	* @return 
	*/  
	public static String getDefaultSimpleFormater() {  
	   return defaultSimpleFormater;  
	}  
	/** 
	* 设置默认简单日期格式字符串 
	*  
	* @param defaultFormatString 
	*/  
	public static void setDefaultSimpleFormater(String defaultFormatString) {  
	   DateUtil.defaultSimpleFormater = defaultFormatString;  
	}  
	/** 
	* 格式化日期 
	*  
	* @param date 
	* @param formatString 
	* @return 
	*/  
	public static String format(Date date, String formatString) {  
	   SimpleDateFormat df = new SimpleDateFormat(formatString);  
	   return df.format(date);  
	}  
	/** 
	* 格式化日期(使用默认格式) 
	*  
	* @param date 
	* @return 
	*/  
	public static String format(Date date) {  
	   return format(date, defaultSimpleFormater);  
	}  
	
	/** 
	* 格式化日期List 
	*   
	*/  
	public static List<String> format(List<Date> list,String formatString){
		List<String> dateStrList=new ArrayList<String>();
		for(Date date:list){
			dateStrList.add(format(date,formatString));
		}
		return dateStrList;
	}
	/**
	 * 格式化日期List（使用默认的Date格式：yyyy-MM-dd）
	 * @param list
	 * @return
	 */
	public static List<String> format(List<Date> list){
		List<String> dateStrList=new ArrayList<String>();
		for(Date date:list){
			dateStrList.add(format(date,defaultDateFormater));
		}
		return dateStrList;
	}
	/** 
	* 转换成日期 
	*  
	* @param dateString 
	* @param formatString 
	* @return 
	*/  
	public static Date parse(String dateString, String formatString) {  
	   SimpleDateFormat df = new SimpleDateFormat(formatString);  
	   try {  
	    return df.parse(dateString);  
	   } catch (ParseException e) {  
	    return null;  
	   }  
	}  
	/** 
	* 转换成日期(使用默认格式) 
	*  
	* @param dateString 
	* @return 
	*/  
	public static Date parse(String dateString) {  
	   return parse(dateString, defaultSimpleFormater);  
	}  
	/** 
	* 昨天 
	*  
	* @return 
	*/  
	public static Date yesterday() {  
	   return addDay(-1);  
	}  
	/** 
	* 明天 
	*  
	* @return 
	*/  
	public static Date tomorrow() {  
	   return addDay(1);  
	}  
	/** 
	* 现在 
	*  
	* @return 
	*/  
	public static Date now() {  
	   return new Date(System.currentTimeMillis());  
	}  
	/** 
	* 按日加 
	*  
	* @param value 
	* @return 
	*/  
	public static Date addDay(int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.DAY_OF_YEAR, value);  
	   return now.getTime();  
	}  
	/** 
	* 按日加,指定日期 
	*  
	* @param date 
	* @param value 
	* @return 
	*/  
	public static Date addDay(Date date, int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date);  
	   now.add(Calendar.DAY_OF_YEAR, value);  
	   return now.getTime();  
	}  
	/** 
	* 按月加 
	*  
	* @param value 
	* @return 
	*/  
	public static Date addMonth(int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.MONTH, value);  
	   return now.getTime();  
	}  
	/** 
	* 按月加,指定日期 
	*  
	* @param date 
	* @param value 
	* @return 
	*/  
	public static Date addMonth(Date date, int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date);  
	   now.add(Calendar.MONTH, value);  
	   return now.getTime();  
	}  
	/** 
	* 按年加 
	*  
	* @param value 
	* @return 
	*/  
	public static Date addYear(int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.YEAR, value);  
	   return now.getTime();  
	}  
	/** 
	* 按年加,指定日期 
	*  
	* @param date 
	* @param value 
	* @return 
	*/  
	public static Date addYear(Date date, int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date);  
	   now.add(Calendar.YEAR, value);  
	   return now.getTime();  
	}  
	/** 
	* 按小时加 
	*  
	* @param value 
	* @return 
	*/  
	public static Date addHour(int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.HOUR_OF_DAY, value);  
	   return now.getTime();  
	}  
	/** 
	* 按小时加,指定日期 
	*  
	* @param date 
	* @param value 
	* @return 
	*/  
	public static Date addHour(Date date, int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date);  
	   now.add(Calendar.HOUR_OF_DAY, value);  
	   return now.getTime();  
	}  
	/** 
	* 按分钟加 
	*  
	* @param value 
	* @return 
	*/  
	public static Date addMinute(int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.MINUTE, value);  
	   return now.getTime();  
	}  
	/** 
	* 按分钟加,指定日期 
	*  
	* @param date 
	* @param value 
	* @return 
	*/  
	public static Date addMinute(Date date, int value) {  
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date);  
	   now.add(Calendar.MINUTE, value);  
	   return now.getTime();  
	}  
	/**
	 * 按秒加
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addSecond(int value){
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.SECOND, value);
	   return now.getTime();
	}
	
	/**
	 * 按秒加,指定日期
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addSecond(Date date,int value){
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date); 
	   now.add(Calendar.SECOND, value);
	   return now.getTime();
	}
	
	/**
	 * 按毫秒加,指定日期
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMillSecond(Date date,int value){
	   Calendar now = Calendar.getInstance();  
	   now.setTime(date); 
	   now.add(Calendar.MILLISECOND, value);
	   return now.getTime();
	}
	
	/**
	 * 按毫秒加
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMillSecond(int value){
	   Calendar now = Calendar.getInstance();  
	   now.add(Calendar.MILLISECOND, value);
	   return now.getTime();
	}
	/** 
	* 年份 
	*  
	* @return 
	*/  
	public static int year() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.YEAR);  
	}  
	/** 
	* 月份 
	*  
	* @return 
	*/  
	public static int month() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.MONTH);  
	}  
	/** 
	* 日(号) 
	*  
	* @return 
	*/  
	public static int day() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.DAY_OF_MONTH);  
	}  
	/** 
	* 小时(点) 
	*  
	* @return 
	*/  
	public static int hour() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.HOUR);  
	}  
	/** 
	* 分钟 
	*  
	* @return 
	*/  
	public static int minute() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.MINUTE);  
	}  
	/** 
	* 秒 
	*  
	* @return 
	*/  
	public static int second() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.SECOND);  
	}  
	/** 
	* 星期几(礼拜几) 
	*  
	* @return 
	*/  
	public static int weekday() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.DAY_OF_WEEK) - 1;  
	}  
	/** 
	* 是上午吗? 
	*  
	* @return 
	*/  
	public static boolean isAm() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.AM_PM) == 0;  
	}  
	/** 
	* 是下午吗? 
	*  
	* @return 
	*/  
	public static boolean isPm() {  
	   Calendar now = Calendar.getInstance();  
	   return now.get(Calendar.AM_PM) == 1;  
	}  
	
	
	
	/** 是否周末 */
	public static boolean isWeekend(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			return true;
		
		return false;
	}
	
}