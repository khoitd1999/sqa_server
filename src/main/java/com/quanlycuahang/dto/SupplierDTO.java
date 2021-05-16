package com.quanlycuahang.dto;

public class SupplierDTO {
	private Long id;
	private String supplierCode;
	private String supplierName;
	private String address;
	private String phone;
	
	public SupplierDTO(Long id, String supplierCode, String supplierName, String address, String phone) {
		super();
		this.id = id;
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.address = address;
		this.phone = phone;
	}

	public SupplierDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
