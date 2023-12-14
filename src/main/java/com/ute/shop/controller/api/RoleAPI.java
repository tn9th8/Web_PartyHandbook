package com.ute.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ute.shop.controller.api.output.RoleOutput;
import com.ute.shop.dto.RoleDTO;
import com.ute.shop.service.IRoleService;

@CrossOrigin
@RestController
public class RoleAPI {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping(value = "role") // /news?page=1&limit=2
	public RoleOutput showRole(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
								@RequestParam(value = "limit", required = false, defaultValue = "2") Integer limit) { //không bắt buộc có tham số
		RoleOutput result = new RoleOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit); // page: chính là offset ở repository. page bđ ở 1,
																	// nhưng offset bđ ở 0. nên page - 1 = offset
			result.setListResult(roleService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (roleService.totalItem()) / limit));
			
		} else {
			//result.setPage(1);
			result.setListResult(roleService.findAll());
			//result.setTotalPage(1);
		}
		return result;

	}
	
	@PostMapping(value = "role")
	public RoleDTO createRole(@RequestBody RoleDTO model) {
		return roleService.save(model);
	}
	
	@PutMapping(value = "role/{id}")
	public RoleDTO updateRole(@RequestBody RoleDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return roleService.save(model);
	}
	
	@DeleteMapping(value = "role")
	public void deleteRole(@RequestBody long[] ids) {
		roleService.delete(ids);
	}
}