package com.quanlycuahang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.MaterialGood;

public interface MaterialGoodRepository extends CrudRepository<MaterialGood, Long>, MaterialGoodRepositoryCustom{
	@Query(value = "select count(*) from MaterialGoods where materialGoodCode = ?1 ; ", nativeQuery = true)
	Integer checkDuplicateCode(String code);
	
	@Query(value = "select * from MaterialGoods ; ", nativeQuery = true)
	List<MaterialGood> findAll();
	
	@Query(value = "select count(1) from PPOrderDetail where materialGoodID = ?1 ; ", nativeQuery = true)
	Integer checkRef(Integer id);

	@Query(value = "select * from MaterialGoods where id = ?1 ; ", nativeQuery = true)
	MaterialGood findOne(Long id);

	@Modifying
	@Query(value = "delete from MaterialGoods where id = ?1 ;", nativeQuery = true)
	void deleteOne(Long id);
}
