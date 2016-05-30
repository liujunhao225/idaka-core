package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.com.idaka.core.mongodb.model.Setting;

@Repository
public interface SettingRepository extends CrudRepository<Setting, String> {

	public Page<Setting> findAll(Pageable pageable);

}
