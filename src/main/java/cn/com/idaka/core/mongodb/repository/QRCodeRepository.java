package cn.com.idaka.core.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.com.idaka.core.mongodb.custom.BaseRepository;
import cn.com.idaka.core.mongodb.model.QRCode;

public interface QRCodeRepository extends BaseRepository<QRCode, String> {
	
	Page<QRCode> findBySid(String sid, Pageable pageable);

}
