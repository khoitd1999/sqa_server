package com.quanlycuahang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.quanlycuahang.entity.MaterialGood;

public interface MaterialGoodRepositoryCustom {
	Page<MaterialGood> findAll(Pageable pageable);
}
