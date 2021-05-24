package com.quanlycuahang.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlycuahang.dto.PPOrderDTO;
import com.quanlycuahang.dto.SupplierDTO;
import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.entity.PPOrder;
import com.quanlycuahang.entity.PPOrderDetail;
import com.quanlycuahang.repository.PPOrderRepository;

@Service
@Transactional
public class PPOrderService {
	@Autowired
	private PPOrderRepository ppOrderRepository;
	
	public Page<PPOrderDTO> loadAll(Pageable pageable) {
		return ppOrderRepository.findAll(pageable);
	}
	
	public List<SupplierDTO> loadAllSupplier() {
		return ppOrderRepository.loadAllSupplier();
	}
	
	public Integer save(PPOrder ppOrder) {
		BigDecimal totalAmount = BigDecimal.ZERO;
		for (PPOrderDetail detail: ppOrder.getPpOrderDetails()) {
			if (detail.getAmount() != null && detail.getAmount().doubleValue() != 0) {
				totalAmount = totalAmount.add(detail.getAmount());
			}
			if (detail.getDiscountAmount() != null && detail.getDiscountAmount().doubleValue() != 0) {
				totalAmount = totalAmount.subtract(detail.getDiscountAmount());
			}
			if (detail.getVatAmount() != null && detail.getVatAmount().doubleValue() != 0) {
				totalAmount = totalAmount.add(detail.getVatAmount());
			}
		}
		ppOrder.setTotalAmount(totalAmount);
		if (ppOrder.getId() != null) {
			ppOrderRepository.save(ppOrder);
			return 0;
		} else {
			Integer count = ppOrderRepository.checkDuplicateCode(ppOrder.getNo());
			if (count > 0) {
				return 1;
			} else {
				ppOrderRepository.save(ppOrder);
				return 0;
			}
		}
	}
	
	public PPOrder findOne(String id) {
		Optional<PPOrder> ppOptional = ppOrderRepository.findById(Long.parseLong(id));
		if (ppOptional.isPresent()) {
			return ppOptional.get();
		} else {
			return null;
		}
	}
	
	public void delete(String id) {
		ppOrderRepository.deleteById(Long.parseLong(id));
	}
}
