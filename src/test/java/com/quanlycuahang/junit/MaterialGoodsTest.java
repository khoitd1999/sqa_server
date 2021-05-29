package com.quanlycuahang.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.repository.PPOrderDetailRepository;
import com.quanlycuahang.service.MaterialGoodService;

@Transactional
public class MaterialGoodsTest extends ApplicationTests {

	@Autowired
	private MaterialGoodService materialGoodService;
	
	@Autowired
	private PPOrderDetailRepository ppOrderDetailRepository;
	
	
	/**
	 * kiểm tra hàm lấy hàng hóa theo id đã tồn tại
	 * */
	@Test
	public void checkFindMaterialGoodsByID() {
		MaterialGood materialGood = materialGoodService.findOne("3");
		assertNotNull(materialGood);
	}
	
	/**
	 * kiểm tra hàm lấy hàng hóa theo id không tồn tại
	 * */
	@Test
	public void checkFindMaterialGoodsByIDInCorrect() {
		MaterialGood materialGood = materialGoodService.findOne("10");
		assertNull(materialGood);
	}
	
	/**
	 * kiểm tra xóa hàng với id đã tồn tại
	 * 
	 * */
	@Test
	public void checkDeleteMaterialGoodsWithIDExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		Integer status = materialGoodService.delete("6");
		assertEquals(new Long(status), new Long(0));
	}
	
	/**
	 * kiểm tra xóa hàng với id không tồn tại
	 * 
	 * */
	@Test
	public void checkDeleteMaterialGoodsWithIDNotExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		Integer status = materialGoodService.delete("10");
		assertEquals(new Long(status), new Long(0));
	}
	
	/**
	 * kiểm tra xóa hàng đã phát sinh ở đơn đặt hàng
	 * */
	@Test
	public void checkDeleteMaterialGoodsWithIDExistInOrder() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		
		// lấy id của 1 hàng hóa đã phát sinh ở trong 1 đơn hàng bất kỳ để xóa
		Long materialGoodID = ppOrderDetailRepository.findAnyOneMaterialGoodsID(new Long(13));
		
		Integer status = materialGoodService.delete(materialGoodID.toString());
		assertEquals(new Long(status), new Long(1));
	}
	
	
	/**
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * */
	@Test
	public void checkSaveMaterialGoodsNew() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		MaterialGood materialGood = new MaterialGood();
		materialGood.setMaterialGoodCode("Test Code");
		materialGood.setMaterialGoodName("Test Name");
		materialGood.setQuantity(BigDecimal.valueOf(1));
		materialGood.setUnitPrice(BigDecimal.valueOf(1));
		
		Integer status = materialGoodService.save(materialGood);
		assertEquals(new Long(status), new Long(0));
	}
	
	/**
	 * kiểm tra lưu mới một hàng hóa có mã đã tồn tại
	 * */
	@Test
	public void checkSaveMaterialGoodsNewWithCodeExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		MaterialGood materialGood = new MaterialGood();
		materialGood.setMaterialGoodCode("MH02");
		materialGood.setMaterialGoodName("Test Name");
		materialGood.setQuantity(BigDecimal.valueOf(1));
		materialGood.setUnitPrice(BigDecimal.valueOf(1));
		
		Integer status = materialGoodService.save(materialGood);
		assertEquals(new Long(status), new Long(1));
	}
	
	/**
	 * kiểm tra sửa một hàng hóa mà không sửa mã của nó
	 * */
	@Test
	public void checkUpdateMaterialGoods() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		MaterialGood materialGood = materialGoodService.findOne("3");
		materialGood.setMaterialGoodName("Test Name");
		materialGood.setQuantity(BigDecimal.valueOf(1));
		materialGood.setUnitPrice(BigDecimal.valueOf(1));
		
		Integer status = materialGoodService.save(materialGood);
		assertEquals(new Long(status), new Long(0));
	}
	
	/**
	 * kiểm tra sửa mã một hàng hóa
	 * */
	@Test
	public void checkUpdateMaterialGoodsWithCodeExist() {
		// 0: là thao tác trong db thành công
		// 1: Là thao tác trong db không thành công
		MaterialGood materialGood = materialGoodService.findOne("3");;
		materialGood.setMaterialGoodCode("MH02");
		Integer status = materialGoodService.save(materialGood);
		assertEquals(new Long(status), new Long(1));
	}
}
