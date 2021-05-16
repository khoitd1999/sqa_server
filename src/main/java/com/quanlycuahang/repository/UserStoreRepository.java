package com.quanlycuahang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quanlycuahang.entity.UserStore;

public interface UserStoreRepository extends CrudRepository<UserStore, Long>{
	@Query(value = "select * from UserStore where username = ?1 and password = ?2", nativeQuery = true)
	UserStore checkUser(String username, String password);
	
	@Query(value = "select * from UserStore where role = 'NV'", nativeQuery = true)
	List<UserStore> findAll();
}
