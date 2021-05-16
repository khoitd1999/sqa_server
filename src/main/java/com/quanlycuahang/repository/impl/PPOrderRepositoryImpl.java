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

import com.quanlycuahang.dto.PPOrderDTO;
import com.quanlycuahang.dto.SupplierDTO;
import com.quanlycuahang.entity.Supplier;
import com.quanlycuahang.repository.PPOrderRepositoryCustom;

public class PPOrderRepositoryImpl implements PPOrderRepositoryCustom{

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<PPOrderDTO> findAll(Pageable pageable) {
		String sql = " from PPOrder p left join Supplier s on p.supplierID = s.id ";
		Query countQuery = entityManager.createNativeQuery("select count(*) " + sql);
		Number total = (Number) countQuery.getSingleResult();
		List<PPOrderDTO> result = new ArrayList<PPOrderDTO>();
		
		if (total.longValue() > 0) {
			Query query = entityManager.createNativeQuery("select p.id id, s.supplierCode supplierCode, p.no no, p.date date, p.totalAmount totalAmount " + sql, "PPOrderDTO");
			query.setFirstResult((int) pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
			result = query.getResultList();
			result.stream().forEach(n -> n.setTotal(total.intValue()));
		}
		return new PageImpl<PPOrderDTO>(result, pageable, total.longValue());
	}

	@Override
	public List<SupplierDTO> loadAllSupplier() {
		// TODO Auto-generated method stub
		String sql = " from Supplier ";
		Query query = entityManager.createNativeQuery("select id, supplierCode, supplierName, address, phone " + sql, "SupplierDTO");	
		return query.getResultList();
	}

}
