/**
 * Repository Factory for all Subrepository
 * @author liangping
 */
package cn.com.idaka.core.mongodb.custom;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;

public class BaseRepositoryFactoryBean<R extends MongoRepository<T, I>, T, I extends Serializable>
		extends MongoRepositoryFactoryBean<R, T, I> {

	@Override
	protected RepositoryFactorySupport getFactoryInstance(
			MongoOperations operations) {
		return new BaseMongoRepositoryFactory<T,I>( operations );
	}
	
	private static class BaseMongoRepositoryFactory<T, ID extends Serializable>
			extends MongoRepositoryFactory {

		private MongoOperations mongo;
		public BaseMongoRepositoryFactory(MongoOperations mongoOperations) {
			super(mongoOperations);
			this.mongo = mongoOperations;
		}

		@SuppressWarnings("unchecked")
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			
			TypeInformation<T> information =  ClassTypeInformation.from((Class<T>)metadata.getDomainType());
			MongoPersistentEntity<T> pe = new BasicMongoPersistentEntity<T>(information);
			MongoEntityInformation<T,ID> mongometa = new MappingMongoEntityInformation<T, ID>(pe);
			
			return new BaseRepositoryImpl<T, ID>( mongometa,  mongo);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepository.class;
		}
	}
}