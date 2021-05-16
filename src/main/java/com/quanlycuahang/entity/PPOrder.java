package com.quanlycuahang.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.quanlycuahang.dto.PPOrderDTO;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "pporder")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SqlResultSetMappings({
    @SqlResultSetMapping(
        name = "PPOrderDTO",
        classes = {
            @ConstructorResult(
                targetClass = PPOrderDTO.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "supplierCode", type = String.class),
                    @ColumnResult(name = "no", type = String.class),
                    @ColumnResult(name = "date", type = LocalDate.class),
                    @ColumnResult(name = "totalAmount", type = BigDecimal.class),
                }
            )
        }
    ),
})
public class PPOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "supplierID")
	private Long supplierID;
	
	@Column(name = "userstoreid")
	private Long userStoreID;
	
	@Column(name = "no")
	private String no;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "pporderid")
	private List<PPOrderDetail> ppOrderDetails = new ArrayList<PPOrderDetail>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Long supplierID) {
		this.supplierID = supplierID;
	}

	public Long getUserStoreID() {
		return userStoreID;
	}

	public void setUserStoreID(Long userStoreID) {
		this.userStoreID = userStoreID;
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

	@JsonGetter(value = "ppOrderDetails")
	public List<PPOrderDetail> getPpOrderDetails() {
		return ppOrderDetails;
	}

	
	public void setPpOrderDetails(List<PPOrderDetail> ppOrderDetails) {
		this.ppOrderDetails = ppOrderDetails;
	}
	
	
}
