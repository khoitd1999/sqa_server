package com.quanlycuahang;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanlycuahang.entity.UserStore;
import com.quanlycuahang.service.UserStoreService;


public class UserStoreTest extends ApplicationTests {

	@Autowired
	private UserStoreService userStoreService;
	
	/**
	 * test account người bán hàng
	 * */
	@Test
	public void testCheckUser() {
		String username = "abc";
		String password = "123";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNotNull(user);
		assertEquals(user.getName(), "Nguyễn Văn A");
		assertEquals(user.getRole(), "NV");
	}
	
	/**
	 * test account người quản lý
	 * */
	@Test
	public void testCheckManager() {
		String username = "admin";
		String password = "123";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNotNull(user);
		assertEquals(user.getName(), "ADMIN");
		assertEquals(user.getRole(), "AD");
	}
	
	/**
	 * test account không gì
	 * */
	@Test
	public void testCheckAccountEmpty() {
		String username = "";
		String password = "";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNull(user);
	}
	
	/**
	 * nhập sai tài khoản
	 * */
	@Test
	public void testCheckAccountInCorrect() {
		String username = "abc";
		String password = "1234";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNull(user);
	}
}
