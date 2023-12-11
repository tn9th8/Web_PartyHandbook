package com.ute.shop.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {

	@Column // nếu ko có bổ sung thông tin thì ko cần column
	private String userName; // user_name VARCHAR(150) NOT NULL,
	@Column
	private String password; // password VARCHAR(150) NOT NULL,
	@Column
	private String fullName; // full_name VARCHAR(150) NULL,
	@Column
	private Integer status; // status int NOT NULL,

	@ManyToMany()
	@JoinTable(name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();

}
