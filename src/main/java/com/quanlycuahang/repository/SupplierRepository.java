package com.quanlycuahang.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
	
	@Query(value = "select * from Supplier where id = ?1", nativeQuery = true)
	Supplier getOne(Long id);
}
