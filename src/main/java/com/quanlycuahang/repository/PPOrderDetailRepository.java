package com.quanlycuahang.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.PPOrderDetail;

public interface PPOrderDetailRepository extends CrudRepository<PPOrderDetail, Long> {
	
	@Query(value = "select materialGoodID from ppOrderDetail where id = ?1 ; ", nativeQuery = true)
	Long findAnyOneMaterialGoodsID(Long id);
}
