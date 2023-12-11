package com.ute.shop.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleEntity extends BaseEntity {
	@Column
	private String code; // code VARCHAR(255) NOT NULL,
	@Column
	private String name; // name VARCHAR(255) NOT NULL,
	@ManyToMany(mappedBy = "roles") //at UserEntity
    private List<UserEntity> users = new ArrayList<>();

}
