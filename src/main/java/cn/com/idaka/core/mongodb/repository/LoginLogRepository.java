package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.com.idaka.core.mongodb.model.Employee;

@Repository
public interface LoginLogRepository extends CrudRepository<Employee, String> {

}
