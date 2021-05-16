package com.quanlycuahang.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.PPOrder;

public interface PPOrderRepository extends CrudRepository<PPOrder, Long>, PPOrderRepositoryCustom{
	
	@Query(value = "select count(*) from PPOrder where no = ?1", nativeQuery = true)
	Integer checkDuplicateCode(String no);
}
