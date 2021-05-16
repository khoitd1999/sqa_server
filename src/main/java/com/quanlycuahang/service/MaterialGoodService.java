package com.quanlycuahang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.repository.MaterialGoodRepository;

@Service
@Transactional
public class MaterialGoodService {
	@Autowired
	private MaterialGoodRepository materialGoodRepository;
	
	public Page<MaterialGood> loadAll(Pageable pageable) {
		return materialGoodRepository.findAll(pageable);
	}
	
	public Integer save(MaterialGood materialGood) {
		if (materialGood.getId() != null) {
			materialGoodRepository.save(materialGood);
			return 0;
		} else {
			Integer count = materialGoodRepository.checkDuplicateCode(materialGood.getMaterialGoodCode());
			if (count > 0) {
				return 1;
			} else {
				materialGoodRepository.save(materialGood);
				return 0;
			}
		}
	}
	
	public MaterialGood findOne(String id) {
		return materialGoodRepository.findById(Long.parseLong(id)).get();
	}
	
	public List<MaterialGood> findAll() {
		return materialGoodRepository.findAll();
	}
	
	public Integer delete(String id) {
		Integer count1 = materialGoodRepository.checkRef(id);
		if (count1 > 0) {
			return 1;
		}
		materialGoodRepository.deleteById(Long.parseLong(id));
		return 0;
	}
}
