package cn.com.idaka.core.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import cn.com.idaka.core.mongodb.model.District;
import cn.com.idaka.core.mongodb.model.Employee;
import cn.com.idaka.core.mongodb.model.EmployeeRole;
import cn.com.idaka.core.mongodb.model.Setting;
import cn.com.idaka.core.util.BeanLoader;
import cn.com.idaka.core.util.StringUtil;

@Service
public class DistrictHelper {
	
	Logger logger = LoggerFactory.getLogger(DistrictHelper.class);
	
	@Autowired
	protected MongoTemplate mongo;
	
	public static DistrictHelper getInstance(){
		return (DistrictHelper) BeanLoader.getBean(DistrictHelper.class);
	}
	
	public List<District> getCityList(){
		Criteria cri = Criteria.where("cityFlag").is(true);
		
		Employee op = (Employee)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(op != null && !StringUtil.isEmpty(op.getCityId()) && isNeedFilterByCity(op)){
			cri.and("id").is(op.getCityId());
		}
		
		return mongo.find(new Query(cri), District.class);
	}
	
	public boolean isNeedFilterByCity(Employee e){
		if(e == null)
			return false;
		
		EmployeeRole role = mongo.findById(e.getRole(), EmployeeRole.class);
		if(role == null)
			return false;
		
		return role.isNeedFilterByCity();
	}
	
	
	
	
	
	
	
	
	
	public Setting findSettingByCity(String city){
		Criteria cri = Criteria.where("cityName").is(city);
		return mongo.findOne(new Query(cri), Setting.class);
	}
}
