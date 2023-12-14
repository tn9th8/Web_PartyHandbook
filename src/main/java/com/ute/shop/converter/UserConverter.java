package com.ute.shop.converter;

import org.springframework.stereotype.Component;

import com.ute.shop.dto.UserDTO;
import com.ute.shop.entity.UserEntity;

@Component
public class UserConverter {

	public UserEntity toEntity(UserDTO dto) { //insert
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullname());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public UserDTO toDTO(UserEntity entity) { //insert
		UserDTO dto = new UserDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setFullname(entity.getFullName());
		dto.setStatus(entity.getStatus());
		//attributes of abstract:
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto, UserEntity entity) { //insert
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullname());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}