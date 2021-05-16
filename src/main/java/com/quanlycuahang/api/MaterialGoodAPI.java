package com.quanlycuahang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.service.MaterialGoodService;
import com.quanlycuahang.utils.PaginationUtil;

@RestController
@RequestMapping(value = "/api")
public class MaterialGoodAPI {
	@Autowired
	private MaterialGoodService materialGoodService;
	
	@GetMapping(value = "/material/load-all")
	private ResponseEntity<List<MaterialGood>> loadAll(@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pageable = new PageRequest(page, size);
		Page<MaterialGood> result = materialGoodService.loadAll(pageable);
		return new ResponseEntity<List<MaterialGood>>(result.getContent(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/material/save")
	private ResponseEntity<Integer> save(@RequestBody MaterialGood materialGood) {
		Integer status = materialGoodService.save(materialGood);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/material/find")
	private ResponseEntity<MaterialGood> findOne(@RequestParam String id) {
		MaterialGood result = materialGoodService.findOne(id);
		return new ResponseEntity<MaterialGood>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/material/find-all")
	private ResponseEntity<List<MaterialGood>> findAll() {
		List<MaterialGood> result = materialGoodService.findAll();
		return new ResponseEntity<List<MaterialGood>>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/material/{id}")
	public ResponseEntity<Integer> delete(@PathVariable String id) {
		Integer status = materialGoodService.delete(id);
        return new ResponseEntity<Integer>(status, HttpStatus.OK);
    }
}
