package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.com.idaka.core.mongodb.model.Show;
@Repository
public interface ShowRepository extends CrudRepository<Show, String> {

	public Page<Show> findBySid(String sid, Pageable pageable);
}
