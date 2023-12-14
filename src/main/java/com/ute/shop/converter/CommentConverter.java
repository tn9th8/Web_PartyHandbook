package com.ute.shop.converter;

import org.springframework.stereotype.Component;

import com.ute.shop.dto.CommentDTO;
import com.ute.shop.entity.CommentEntity;

@Component
public class CommentConverter {

	public CommentEntity toEntity(CommentDTO dto) { //insert
		CommentEntity entity = new CommentEntity();
		entity.setContent(dto.getContent());
		// FK: entity.setNews(dto.);
		// FK:
		return entity;
	}
	
	public CommentDTO toDTO(CommentEntity entity) { //return sau khi insert/update		
		CommentDTO dto = new CommentDTO();
		//id
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		//attributes of DTO
		dto.setContent(entity.getContent());
		dto.setNewsId(entity.getNews().getId());
		dto.setUserId(entity.getUser().getId());
		//attributes of abstract:
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());	
		return dto;
	}
	
	public CommentEntity toEntity(CommentDTO dto,CommentEntity entity ) { //insert
		entity.setContent(dto.getContent());
		return entity;
	}
}