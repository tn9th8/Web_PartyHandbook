package com.ute.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ute.shop.converter.RoleConverter;
import com.ute.shop.dto.RoleDTO;
import com.ute.shop.entity.RoleEntity;
import com.ute.shop.repository.IRoleRepository;
import com.ute.shop.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public RoleDTO save(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity();
		if (roleDTO.getId() != null) {
			Optional<RoleEntity> optional = roleRepository.findById(roleDTO.getId());
			if (optional.isPresent()) {
				RoleEntity oldRoleEntity = optional.get();
				roleEntity = roleConverter.toEntity(roleDTO, oldRoleEntity); // lấy newsDTO cập nhật lên old
			}
		}
		else { //ko có id: insert (vì id tự tăng)
			roleEntity = roleConverter.toEntity(roleDTO);
		}
		roleEntity = roleRepository.save(roleEntity);
		return roleConverter.toDTO(roleEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			roleRepository.deleteById(item);
		}
	}

	@Override
	public List<RoleDTO> findAll(Pageable pageable) {
		List<RoleDTO> results = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll(pageable).getContent();
		for (RoleEntity item: entities) {
			RoleDTO newsDTO = roleConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}

	@Override
	public int totalItem() {
		return (int) roleRepository.count();
	}

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> results = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for (RoleEntity item: entities) {
			RoleDTO newsDTO = roleConverter.toDTO(item);
			results.add(newsDTO);
		}
		return results; //list rỗng khác null
	}
}