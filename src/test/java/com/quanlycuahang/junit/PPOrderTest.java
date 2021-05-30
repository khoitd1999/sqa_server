package com.quanlycuahang.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quanlycuahang.entity.PPOrder;
import com.quanlycuahang.entity.PPOrderDetail;
import com.quanlycuahang.service.PPOrderService;

public class PPOrderTest extends ApplicationTests {
	@Autowired
	private PPOrderService ppOrderService;
	
	
	/**
	 * kiểm tra hàm lấy đơn hàng theo id đã tồn tại
	 * */
	@Test
	public void checkFindOrderByID() {
		PPOrder ppOrder = ppOrderService.findOne("5");
		assertNotNull(ppOrder);
	}
	
	/**
	 * kiểm tra hàm lấy đơn hàng theo id không tồn tại
	 * */
	@Test
	public void checkFindOrderByIDInCorrect() {
		PPOrder ppOrder = ppOrderService.findOne("100");
		assertNull(ppOrder);
	}
	
	/**
	 * kiểm tra xóa đơn hàng với id đã tồn tại
	 * 
	 * */
	@Test
	@Transactional
	public void checkDeleteOrderWithIDExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		ppOrderService.delete("5");
		PPOrder ppOrder = ppOrderService.findOne("5");
		assertNull(ppOrder);
	}
	
	/**
	 * kiểm tra xóa hàng với id không tồn tại
	 * 
	 * */
	@Test
	@Transactional
	public void checkDeleteOrderWithIDNotExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		ppOrderService.delete("100");
		PPOrder ppOrder = ppOrderService.findOne("100");
		assertNull(ppOrder);
	}
	
	/**
	 * kiểm tra lưu mới một đơn hàng có mã chưa tồn tại
	 * */
	@Test
	public void checkSaveOrderNew() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		PPOrder ppOrder = new PPOrder();
		ppOrder.setNo("DH100");
		ppOrder.setDate(LocalDate.now());
		
		List<PPOrderDetail> ppOrderDetails = new ArrayList<PPOrderDetail>();
		PPOrderDetail ppOrderDetail = new PPOrderDetail();
		ppOrderDetail.setMaterialGoodID((long) 3);
		ppOrderDetail.setQuantity(BigDecimal.valueOf(10));
		ppOrderDetail.setUnitPrice(BigDecimal.valueOf(10000));
		// 100.000
		ppOrderDetail.setAmount(ppOrderDetail.getUnitPrice().multiply(ppOrderDetail.getQuantity()));
		// tỉ lệ chiết khấu là 20%
		ppOrderDetail.setDiscountRate(BigDecimal.valueOf(0.2));
		// 20.000
		ppOrderDetail.setDiscountAmount(ppOrderDetail.getAmount().multiply(ppOrderDetail.getDiscountRate()));
		// tỉ lệ thuế VAT là 5%
		ppOrderDetail.setVatRate(BigDecimal.valueOf(0.05));
		// 5.000
		ppOrderDetail.setVatAmount(ppOrderDetail.getAmount().multiply(ppOrderDetail.getVatRate()));
		
		ppOrderDetails.add(ppOrderDetail);
		ppOrder.setPpOrderDetails(ppOrderDetails);
		
		Integer status = ppOrderService.save(ppOrder);
		assertEquals(new Long(status), new Long(0));
		assertEquals(ppOrder.getTotalAmount().longValue(), 85000);
		
		// Rollback
		ppOrderService.delete(ppOrder.getId().toString());
	}
	
	/**
	 * kiểm tra lưu mới một đơn hàng có mã đã tồn tại
	 * */
	@Test
	@Transactional
	public void checkSaveOrderNewWithCodeExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		PPOrder ppOrder = new PPOrder();
		ppOrder.setNo("DH001");
		ppOrder.setDate(LocalDate.now());
		
		List<PPOrderDetail> ppOrderDetails = new ArrayList<PPOrderDetail>();
		PPOrderDetail ppOrderDetail = new PPOrderDetail();
		ppOrderDetail.setMaterialGoodID((long) 3);
		ppOrderDetail.setQuantity(BigDecimal.valueOf(10));
		ppOrderDetail.setUnitPrice(BigDecimal.valueOf(10000));
		// 100.000
		ppOrderDetail.setAmount(ppOrderDetail.getUnitPrice().multiply(ppOrderDetail.getQuantity()));
		// tỉ lệ chiết khấu là 20%
		ppOrderDetail.setDiscountRate(BigDecimal.valueOf(0.2));
		// 20.000
		ppOrderDetail.setDiscountAmount(ppOrderDetail.getAmount().multiply(ppOrderDetail.getDiscountRate()));
		// tỉ lệ thuế VAT là 5%
		ppOrderDetail.setVatRate(BigDecimal.valueOf(0.05));
		// 5.000
		ppOrderDetail.setVatAmount(ppOrderDetail.getAmount().multiply(ppOrderDetail.getVatRate()));
		
		ppOrderDetails.add(ppOrderDetail);
		ppOrder.setPpOrderDetails(ppOrderDetails);
		
		Integer status = ppOrderService.save(ppOrder);
		assertEquals(new Long(status), new Long(1));
	}
	
	/**
	 * kiểm tra sửa một đơn hàng mà không sửa mã đơn hàng của nó
	 * */
	@Test
	@Transactional
	public void checkUpdateOrder() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		PPOrder ppOrder = ppOrderService.findOne("5");
		// sửa ngày nhận hóa đơn
		ppOrder.setDate(LocalDate.now());
		
		Integer status = ppOrderService.save(ppOrder);
		assertEquals(new Long(status), new Long(0));
	}
	
	/**
	 * kiểm tra sửa mã của một đơn hàng 
	 * */
	@Test
	@Transactional
	public void checkUpdateOrderWithCodeExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		PPOrder ppOrder = ppOrderService.findOne("5");
		// sửa ngày nhận hóa đơn
		ppOrder.setNo("ádasdsad");
		
		Integer status = ppOrderService.save(ppOrder);
		assertEquals(new Long(status), new Long(1));
	}
}
