package cn.com.idaka.core.mongodb.repository.authority;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.idaka.core.mongodb.model.EmployeeRole;

public interface EmployeeRoleRepository extends
		PagingAndSortingRepository<EmployeeRole, String> {

}
