package com.quanlycuahang.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.repository.MaterialGoodRepositoryCustom;

public class MaterialGoodRepositoryImpl implements MaterialGoodRepositoryCustom{

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<MaterialGood> findAll(Pageable pageable) {
		String sql = " from MaterialGoods ";
		Query countQuery = entityManager.createNativeQuery("select count(*) " + sql);
		Number total = (Number) countQuery.getSingleResult();
		List<MaterialGood> result = new ArrayList<MaterialGood>();
		
		if (total.longValue() > 0) {
			Query query = entityManager.createNativeQuery("select * " + sql, MaterialGood.class);
			query.setFirstResult((int) pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
			result = query.getResultList();
			result.stream().forEach(n -> n.setTotal(total.intValue()));
		}
		return new PageImpl<MaterialGood>(result, pageable, total.longValue());
	}

}
