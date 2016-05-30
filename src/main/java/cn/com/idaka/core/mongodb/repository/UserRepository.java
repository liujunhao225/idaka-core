package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import cn.com.idaka.core.mongodb.custom.BaseRepository;
import cn.com.idaka.core.mongodb.model.User;

@Repository
public interface UserRepository extends BaseRepository<User, String> {

	public User findOneByFakeidAndSid(String fakeid, String sid);
	
	public Page<User> findBySid(String sid, Pageable pageable);
	
	public Page<User> findOneBySidAndFromscene(String sid, int fromscene, Pageable pageable);
}
