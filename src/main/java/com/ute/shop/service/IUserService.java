package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO userDTO);
	void delete(long[] ids);
	List<UserDTO> findAll(Pageable pageable);
	int totalItem();
	List<UserDTO> findAll();
}