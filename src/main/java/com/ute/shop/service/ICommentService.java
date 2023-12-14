package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.CommentDTO;

public interface ICommentService {

	CommentDTO save(CommentDTO commentDTO);
	void delete(long[] ids);
	List<CommentDTO> findAll(Pageable pageable);
	int totalItem();
	List<CommentDTO> findAll();
	CommentDTO findById(Long id);
}