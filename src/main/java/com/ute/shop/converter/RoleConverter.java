package com.ute.shop.converter;

import org.springframework.stereotype.Component;

import com.ute.shop.dto.RoleDTO;
import com.ute.shop.entity.RoleEntity;

@Component
public class RoleConverter {

	public RoleEntity toEntity(RoleDTO dto) { // insert
		RoleEntity entity = new RoleEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

	public RoleDTO toDTO(RoleEntity entity) { // insert
		RoleDTO dto = new RoleDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		// attributes of abstract:
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public RoleEntity toEntity(RoleDTO dto, RoleEntity entity) { // insert
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}