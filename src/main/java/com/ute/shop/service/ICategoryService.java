package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.CategoryDTO;

public interface ICategoryService {

	CategoryDTO save(CategoryDTO categoryDTO);
	void delete(long[] ids);
	List<CategoryDTO> findAll(Pageable pageable);
	int totalItem();
	List<CategoryDTO> findAll();
}