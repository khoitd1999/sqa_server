package com.quanlycuahang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlycuahang.entity.UserStore;
import com.quanlycuahang.repository.UserStoreRepository;

@Service
@Transactional
public class UserStoreService {
	
	@Autowired
	private UserStoreRepository userStoreRepository;
	
	public UserStore checkUser(UserStore user) {
		return userStoreRepository.checkUser(user.getUsername(), user.getPassword());
	}
	
	public List<UserStore> loadAll() {
		return userStoreRepository.findAll();
	}
}
