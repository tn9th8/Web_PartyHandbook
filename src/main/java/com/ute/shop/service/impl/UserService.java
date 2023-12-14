package com.ute.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ute.shop.converter.UserConverter;
import com.ute.shop.dto.UserDTO;
import com.ute.shop.entity.UserEntity;
import com.ute.shop.repository.IUserRepository;
import com.ute.shop.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if (userDTO.getId() != null) {
			Optional<UserEntity> optional = userRepository.findById(userDTO.getId());
			if (optional.isPresent()) {
				UserEntity oldUserEntity = optional.get();
				userEntity = userConverter.toEntity(userDTO, oldUserEntity); // lấy newsDTO cập nhật lên old
			}
		}
		else { //ko có id: insert (vì id tự tăng)
			userEntity = userConverter.toEntity(userDTO);
		}
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			userRepository.deleteById(item);
		}
		
	}
	
	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO newsDTO = userConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public int totalItem() {
		return (int) userRepository.count();
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item: entities) {
			UserDTO newsDTO = userConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}
}