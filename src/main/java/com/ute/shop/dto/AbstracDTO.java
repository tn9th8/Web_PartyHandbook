package com.ute.shop.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class AbstracDTO<T> {
	
	private Long id;
	private Date createdDate;
	private String createdBy; 
	private Date modifiedDate; 
	private String modifiedBy;
	private List<T> listResult = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) { // có setter id
		this.id = id;
	}
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
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
}
//Generic T type: T là đối tượng mình làm việc mà phải truyền vào
