/**
 * Basic Repository for common custom methods
 * @author liangping
 */
package cn.com.idaka.core.mongodb.custom;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public abstract interface BaseRepository <T, ID extends Serializable>
	  extends PagingAndSortingRepository<T, ID>, MongoRepository<T, ID> {

	  public Page<T> search(Query query, Pageable pageable);
	  
	  public Page<T> search(Query query, Pageable pageable, boolean restrict);
}