/**
 * implement for wootide basic repository
 * @author liangping
 */
package cn.com.idaka.core.mongodb.repository.base;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class CustomRepositoryImpl<T, ID extends Serializable> extends
		SimpleMongoRepository<T, ID> implements CustomRepositoryBase<T, ID> {
	
	public CustomRepositoryImpl(MongoEntityInformation<T, ID> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@Override
	public Page<T> search(Query query, Pageable pageable) {
		return search(query, pageable, false );
	}

	@Override
	public Page<T> search(Query query, Pageable pageable, boolean restrict) {
		if(restrict){
			query.restrict(this.getEntityInformation().getJavaType(), this.getEntityInformation().getJavaType());
		}
		long total = this.getMongoOperations().count(query, this.getEntityInformation().getJavaType() );
		return new PageImpl<T>(this.getMongoOperations().find(query.with(pageable), this.getEntityInformation().getJavaType()), pageable, total);
	}

}