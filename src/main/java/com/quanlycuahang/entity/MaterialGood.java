package com.quanlycuahang.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "materialgoods")
public class MaterialGood implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "materialgoodcode")
	private String materialGoodCode;
	
	@Column(name = "materialgoodname")
	private String materialGoodName;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "unitprice")
	private BigDecimal unitPrice;
	
	@Column(name = "quantity")
	private BigDecimal quantity;
	
	@Transient
	private Integer total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialGoodCode() {
		return materialGoodCode;
	}

	public void setMaterialGoodCode(String materialGoodCode) {
		this.materialGoodCode = materialGoodCode;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
