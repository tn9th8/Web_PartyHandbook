package com.ute.shop.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryEntity extends BaseEntity {

	@Column
	private String name; // name VARCHAR(255) NOT NULL,
	@Column
	private String code; // code VARCHAR(255) NOT NULL,
	@OneToMany(mappedBy = "category") //at CategoryEntity
	private List<NewsEntity> newss = new ArrayList<>();

}
