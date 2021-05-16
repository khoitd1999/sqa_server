package com.quanlycuahang.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.quanlycuahang.dto.PPOrderDTO;
import com.quanlycuahang.dto.SupplierDTO;

@Entity
@Table(name = "supplier")
@SqlResultSetMappings({
    @SqlResultSetMapping(
        name = "SupplierDTO",
        classes = {
            @ConstructorResult(
                targetClass = SupplierDTO.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "supplierCode", type = String.class),
                    @ColumnResult(name = "supplierName", type = String.class),
                    @ColumnResult(name = "address", type = String.class),
                    @ColumnResult(name = "phone", type = String.class),
                }
            )
        }
    ),
})
public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "suppliercode")
	private String supplierCode;
	
	@Column(name = "supplierName")
	private String supplierName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;

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
