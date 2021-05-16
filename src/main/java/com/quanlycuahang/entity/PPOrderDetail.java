package com.quanlycuahang.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pporderdetail")
public class PPOrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "pporderid")
	private Long ppOrderID;
	
	@Column(name = "materialgoodid")
	private Long materialGoodID;
	
	@Column(name = "materialgoodname")
	private String materialGoodName;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "unitprice")
	private BigDecimal unitPrice;
	
	@Column(name = "quantity")
	private BigDecimal quantity;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "vatrate")
	private BigDecimal vatRate;
	
	@Column(name = "vatamount")
	private BigDecimal vatAmount;
	
	@Column(name = "discountrate")
	private BigDecimal discountRate;
	
	@Column(name = "discountamount")
	private BigDecimal discountAmount;

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

	public Long getMaterialGoodID() {
		return materialGoodID;
	}

	public void setMaterialGoodID(Long materialGoodID) {
		this.materialGoodID = materialGoodID;
	}

	public String getMaterialGoodName() {
		return materialGoodName;
	}

	public void setMaterialGoodName(String materialGoodName) {
		this.materialGoodName = materialGoodName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	
}
