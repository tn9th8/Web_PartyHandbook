package com.ute.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ute.shop.converter.CategoryConverter;
import com.ute.shop.dto.CategoryDTO;
import com.ute.shop.entity.CategoryEntity;
import com.ute.shop.repository.ICategoryRepository;
import com.ute.shop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
			Optional<CategoryEntity> optional = categoryRepository.findById(categoryDTO.getId());
			if (optional.isPresent()) {
				CategoryEntity oldCategoryEntity = optional.get();
				categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategoryEntity); // lấy newsDTO cập nhật lên old
			}
		}
		else { //ko có id: insert (vì id tự tăng)
			categoryEntity = categoryConverter.toEntity(categoryDTO);
		}
		categoryEntity = categoryRepository.save(categoryEntity);
		return categoryConverter.toDTO(categoryEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			categoryRepository.deleteById(item);
		}
		
	}
	
	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item: entities) {
			CategoryDTO newsDTO = categoryConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public int totalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			CategoryDTO newsDTO = categoryConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}
}