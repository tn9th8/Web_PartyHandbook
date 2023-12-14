package com.ute.shop.converter;

import org.springframework.stereotype.Component;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.entity.NewsEntity;

@Component
public class NewsConverter {
	
	public NewsEntity toEntity(NewsDTO dto) { //insert
		NewsEntity entity = new NewsEntity();
		entity.setTittle(dto.getTitle());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public NewsDTO toDTO(NewsEntity entity) { //return sau khi insert/update		
		NewsDTO dto = new NewsDTO();
		//id
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		//attributes of DTO
		dto.setTitle(entity.getTittle());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setContent(entity.getContent());
		dto.setCategoryCode(entity.getCategory().getCode());
		//attributes of abstract:
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		
		
		return dto;
	}
	
	public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) { //update:enity là cũ, được update bởi dto
		entity.setTittle(dto.getTitle());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setContent(dto.getContent());
		return entity;
	}
}
