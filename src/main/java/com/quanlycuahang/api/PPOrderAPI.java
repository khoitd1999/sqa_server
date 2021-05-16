package com.quanlycuahang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.quanlycuahang.dto.PPOrderDTO;
import com.quanlycuahang.dto.SupplierDTO;
import com.quanlycuahang.entity.MaterialGood;
import com.quanlycuahang.entity.PPOrder;
import com.quanlycuahang.entity.Supplier;
import com.quanlycuahang.service.PPOrderService;

@RestController
@RequestMapping(value = "/api")
public class PPOrderAPI {
	@Autowired
	private PPOrderService ppOrderService;
	
	@GetMapping(value = "/pporder/load-all")
	private ResponseEntity<List<PPOrderDTO>> loadAll(@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pageable = new PageRequest(page, size);
		Page<PPOrderDTO> result = ppOrderService.loadAll(pageable);
		return new ResponseEntity<List<PPOrderDTO>>(result.getContent(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/pporder/get-all-supplier")
	private ResponseEntity<List<SupplierDTO>> loadAll() {
		List<SupplierDTO> result = ppOrderService.loadAllSupplier();
		return new ResponseEntity<List<SupplierDTO>>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/pporder/save")
	private ResponseEntity<Integer> save(@RequestBody PPOrder ppOrder) {
		Integer status = ppOrderService.save(ppOrder);
		return new ResponseEntity<Integer>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pporder/find")
	private ResponseEntity<PPOrder> findOne(@RequestParam String id) {
		PPOrder result = ppOrderService.findOne(id);
		return new ResponseEntity<PPOrder>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/pporder/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		ppOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
