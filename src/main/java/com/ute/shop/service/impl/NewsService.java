package com.ute.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	public void save(NewsDTO newsDTO) {
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
		newsDTO.setCategoryCode("chinh-tri");
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);		
		newsEntity = newsRepository.save(newsEntity);
	}


	@Override
	public void delete(List<Long> ids) {
		for(Long item: ids) {
			newsRepository.deleteById(item);
		}
		
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for (NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public int totalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll();
		for (NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public List<NewsDTO> findTop5ByOrderByIdDesc() {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findTop5ByOrderByIdDesc();
		for (NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public NewsDTO findById(Long id) {
		NewsDTO newsDTO = new NewsDTO();
		Optional<NewsEntity> optional = newsRepository.findById(id);
		if (optional.isPresent()) {
			NewsEntity newsEntity = optional.get();
			newsDTO = newsConverter.toDTO(newsEntity); // lấy newsDTO cập nhật lên old
		}
//		ProductDto productDto = new ProductDto();
//		if(optional.isPresent()) {
//			Product entity = optional.get();
//			BeanUtils.copyProperties(entity, productDto);
//			productDto.setCategoryId(entity.getCategory().getCategoryId());
//			productDto.setIsEdit(false);
//		}
		return newsDTO;
	}

	@Override
	public List<NewsDTO> findAllByOrderByIdDesc() {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAllByOrderByIdDesc();
		for (NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public void deleteById(Long id) {
		newsRepository.deleteById(id);
	}

}
