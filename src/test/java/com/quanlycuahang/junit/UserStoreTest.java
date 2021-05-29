package com.quanlycuahang.junit;


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
	 * test account đúng
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
	 * test tài khoản mật khẩu bỏ trống
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
	 * nhập đúng tài khoản, sai mật khẩu
	 * */
	@Test
	public void testCheckAccountInCorrect() {
		String username = "abc";
		String password = "1234";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNull(user);
	}
	
	/**
	 * nhập sai tài khoản, đúng mật khẩu
	 * */
	@Test
	public void testCheckAccountInCorrect1() {
		String username = "abcd";
		String password = "123";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNull(user);
	}
	
	/**
	 * nhập sai tài khoản, sai mật khẩu
	 * */
	@Test
	public void testCheckAccountInCorrect2() {
		String username = "abcd";
		String password = "1234";
		UserStore user = new UserStore(username, password);
		user = userStoreService.checkUser(user);
		
		assertNull(user);
	}
}
