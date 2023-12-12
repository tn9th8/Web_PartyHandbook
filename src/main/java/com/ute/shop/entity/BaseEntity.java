package com.ute.shop.entity;

import java.util.Date; // date + time

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@MappedSuperclass //mapping thuộc tính của cha cho con để tạo table á
@EntityListeners(AuditingEntityListener.class) //kỹ thuật, công nghệ jpa auditing
public class BaseEntity {
	
	@Id //NOT NULL PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 
	private Long id; //id bigint //chung tên là id để đồng bộ
	
	@Column
	@CreatedBy
	private String createdBy; //created_by VARCHAR(255) NULL,
	
	@Column 
	@CreatedDate
	private Date createdDate; //created_date TIMESTAMP NULL,
	
	@Column 
	@LastModifiedBy
	private String modifiedBy; //modified_by VARCHAR(255) NULL
	
	@Column
	@LastModifiedDate
	private Date modifiedDate; //modified_date TIMESTAMP NULL,
	
	public Long getId() {
		return id;
	}
//	public void setId(Long id) { //chỉ có getter, ko có setter vì nó auto_increment 
//		this.id = id;
//	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}

//ctrl + space: gợi ý keyword
//ctrl + shift + m: select thư viện cần thiết
//ctrl + shift + o: remove thư viện dữ thừa
