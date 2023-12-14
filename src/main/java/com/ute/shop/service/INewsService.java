package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.NewsDTO;

public interface INewsService {
	
	void save(NewsDTO newsDTO);
	void delete(List<Long> ids);
	List<NewsDTO> findAll(Pageable pageable);
	int totalItem();
	List<NewsDTO> findAll();
	
	List<NewsDTO> findTop5ByOrderByIdDesc();
	NewsDTO findById(Long id);
	List<NewsDTO> findAllByOrderByIdDesc();
	void deleteById(Long id);
	
}
// giữ ctrl + rà chuột lại update + open implement
