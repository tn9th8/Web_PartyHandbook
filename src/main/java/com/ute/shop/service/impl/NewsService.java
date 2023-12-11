package com.ute.shop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ute.shop.converter.NewsConverter;
import com.ute.shop.dto.NewsDTO;
import com.ute.shop.entity.CategoryEntity;
import com.ute.shop.entity.NewsEntity;
import com.ute.shop.repository.ICategoryRepository;
import com.ute.shop.repository.INewsRepository;
import com.ute.shop.service.INewsService;

@Service
public class NewsService implements INewsService {
	
	@Autowired
	private INewsRepository newsRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private NewsConverter newsConverter;

	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		/*
		 * Thực hiện lưu 1 entity khi insert hoặc update:
		 * S1: Kiểm tra update/insert, rồi convert dto to entity
		 * S2: set F.key category là category-entity
		 * S3: save 1 entity
		 * S4: convert entity to dto, and return
		 * */
		NewsEntity newsEntity = new NewsEntity();
		if (newsDTO.getId() != null) { //có id: update
			Optional<NewsEntity> optional = newsRepository.findById(newsDTO.getId());
			if (optional.isPresent()) {
				NewsEntity oldNewsEntity = optional.get();
				newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity); // lấy newsDTO cập nhật lên old
			}
		} else { //ko có id: insert (vì id tự tăng)
			newsEntity = newsConverter.toEntity(newsDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}
}
