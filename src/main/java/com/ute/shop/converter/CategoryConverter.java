package com.ute.shop.converter;

import org.springframework.stereotype.Component;

import com.ute.shop.dto.CategoryDTO;
import com.ute.shop.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryEntity toEntity(CategoryDTO dto) { //insert
		CategoryEntity entity = new CategoryEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
	
	public CategoryDTO toDTO(CategoryEntity entity) { //insert
		CategoryDTO dto = new CategoryDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) { //insert
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}