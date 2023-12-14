package com.ute.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ute.shop.converter.CommentConverter;
import com.ute.shop.dto.CommentDTO;
import com.ute.shop.entity.CommentEntity;
import com.ute.shop.entity.NewsEntity;
import com.ute.shop.entity.UserEntity;
import com.ute.shop.repository.ICommentRepository;
import com.ute.shop.repository.INewsRepository;
import com.ute.shop.repository.IUserRepository;
import com.ute.shop.service.ICommentService;

@Service
public class CommentService implements ICommentService{

	@Autowired
	private ICommentRepository commentRepository;

	@Autowired
	private INewsRepository newsRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private CommentConverter commentConverter;

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		if (commentDTO.getId() != null) {
			Optional<CommentEntity> optional = commentRepository.findById(commentDTO.getId());
			if (optional.isPresent()) {
				CommentEntity oldCommentEntity = optional.get();
				commentEntity = commentConverter.toEntity(commentDTO, oldCommentEntity); // lấy newsDTO cập nhật lên old
			}
		}
		else { //ko có id: insert (vì id tự tăng)
			commentEntity = commentConverter.toEntity(commentDTO);
		}
		Optional<NewsEntity> optional1 = newsRepository.findById(commentDTO.getNewsId());
		if (optional1.isPresent()) {
			NewsEntity newsEntity = optional1.get();
			commentEntity.setNews(newsEntity);
		}
		Optional<UserEntity> optional2 = userRepository.findById(commentDTO.getUserId());
		if (optional1.isPresent()) {
			UserEntity userEntity = optional2.get();
			commentEntity.setUser(userEntity);
		}
		commentEntity = commentRepository.save(commentEntity);
		return commentConverter.toDTO(commentEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			commentRepository.deleteById(item);
		}
		
	}
	
	@Override
	public List<CommentDTO> findAll(Pageable pageable) {
		List<CommentDTO> results = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll(pageable).getContent();
		for (CommentEntity item: entities) {
			CommentDTO newsDTO = commentConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public int totalItem() {
		return (int) commentRepository.count();
	}

	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> results = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll();
		for (CommentEntity item: entities) {
			CommentDTO newsDTO = commentConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}
	
	@Override
	public CommentDTO findById(Long id) {
		CommentDTO commentDTO = new CommentDTO();
		Optional<CommentEntity> optional = commentRepository.findById(id);
		if (optional.isPresent()) {
			CommentEntity commentEntity = optional.get();
			commentDTO = commentConverter.toDTO(commentEntity); // lấy newsDTO cập nhật lên old
		}
		return commentDTO;
	}
}