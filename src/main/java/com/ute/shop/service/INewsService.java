package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.NewsDTO;

public interface INewsService {
	
	NewsDTO save(NewsDTO newsDTO);
	void delete(long[] ids);
	List<NewsDTO> findAll(Pageable pageable);
	int totalItem();
	List<NewsDTO> findAll();
}
// giữ ctrl + rà chuột lại update + open implement
