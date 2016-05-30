package cn.com.idaka.core.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.com.idaka.core.mongodb.custom.BaseRepository;
import cn.com.idaka.core.mongodb.model.Feedback;

public interface FeedbackRepository extends BaseRepository<Feedback, String> {

	public Page<Feedback> findBySidAndType(String sid, int type,Pageable pageable);
	
	public Page<Feedback> findBySidAndTypeAndStatus(String sid, int type,int status, Pageable pageable);
	
	public Page<Feedback> findBySid(String sid, Pageable pageable);
	
	public List<Feedback> findBySidAndKeyword1();

	public Page<Feedback> findBySidAndTypeAndCatelogAndStatus(String sid, int type,String catelogid, int status, Pageable pageable);

	/**
	 * 根据产品名称模糊查询正常状态下的其他供应商产品
	 * @return
	 */
	public List<Feedback> findByTitleLikeAndStatus(String title, int status, Pageable pageable);
	/**
	 * 根据产品名称模糊查询正常状态下的其他供应商产品
	 * @return
	 */
	public List<Feedback> findBySidAndTypeAndStatus(String sid, int type, int status);

}
