package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.idaka.core.mongodb.model.EmployeeMetaResource;

public interface EmployeeMetaSourceRepository extends
		PagingAndSortingRepository<EmployeeMetaResource, String> {

}
