package com.quanlycuahang.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PPOrderDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long ppOrderID;
	private String supplierCode;
	private String no;
	private LocalDate date;
	private BigDecimal totalAmount;
	private Integer total;
	
	public PPOrderDTO() {
	}
	
	public PPOrderDTO(Long id, String supplierCode, String no, LocalDate date, BigDecimal totalAmount) {
		super();
		this.id = id;
		this.supplierCode = supplierCode;
		this.no = no;
		this.date = date;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPpOrderID() {
		return ppOrderID;
	}
	public void setPpOrderID(Long ppOrderID) {
		this.ppOrderID = ppOrderID;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}	
}
