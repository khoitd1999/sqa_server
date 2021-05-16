package com.quanlycuahang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlycuahang.entity.UserStore;
import com.quanlycuahang.service.UserStoreService;

@RestController
@RequestMapping(value = "/api")
public class UserStoreAPI {
	
	@Autowired
	private UserStoreService userStoreService;
	
	@PostMapping(value = "/check")
	private ResponseEntity<UserStore> checkUser(@RequestBody UserStore userStore) {
		UserStore user = userStoreService.checkUser(userStore);
		return new ResponseEntity<UserStore>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/load-all")
	private ResponseEntity<List<UserStore>> loadAll() {
		List<UserStore> list = userStoreService.loadAll();
		return new ResponseEntity<List<UserStore>>(list, HttpStatus.OK);
	}
}
