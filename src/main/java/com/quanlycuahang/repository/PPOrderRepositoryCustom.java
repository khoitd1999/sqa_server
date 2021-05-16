package com.quanlycuahang.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.quanlycuahang.dto.PPOrderDTO;
import com.quanlycuahang.dto.SupplierDTO;
import com.quanlycuahang.entity.Supplier;

public interface PPOrderRepositoryCustom {
	Page<PPOrderDTO> findAll(Pageable pageable);
	
	List<SupplierDTO> loadAllSupplier();
}
