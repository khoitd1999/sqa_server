package com.quanlycuahang.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.PPOrder;

public interface PPOrderRepository extends CrudRepository<PPOrder, Long>, PPOrderRepositoryCustom{
	
	@Query(value = " select * from PPOrder where no = ?1; ", nativeQuery = true)
	PPOrder findOneByNo(String no);
	
	@Query(value = "select count(*) from PPOrder where no = ?1", nativeQuery = true)
	Integer checkDuplicateCode(String no);
	
	@Modifying
	@Query(value = " delete from PPOrder where id = ?1 ; ", nativeQuery = true)
	void deleteOne(Long id);
	
	@Modifying
	@Query(value = " delete from pporderdetail where pporderid = ?1 ; ", nativeQuery = true)
	void deleteChildren(Long id);
}
