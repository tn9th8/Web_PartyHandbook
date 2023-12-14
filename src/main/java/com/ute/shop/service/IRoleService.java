package com.ute.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ute.shop.dto.RoleDTO;

public interface IRoleService {

	RoleDTO save(RoleDTO roleDTO);
	void delete(long[] ids);
	List<RoleDTO> findAll(Pageable pageable);
	int totalItem();
	List<RoleDTO> findAll();
}