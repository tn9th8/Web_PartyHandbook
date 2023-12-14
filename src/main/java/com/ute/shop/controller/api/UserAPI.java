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

import com.ute.shop.controller.api.output.UserOutput;
import com.ute.shop.dto.UserDTO;
import com.ute.shop.service.IUserService;


@CrossOrigin
@RestController
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "user") // /news?page=1&limit=2
	public UserOutput showUser(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
								@RequestParam(value = "limit", required = false, defaultValue = "2") Integer limit) { //không bắt buộc có tham số
		UserOutput result = new UserOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit); // page: chính là offset ở repository. page bđ ở 1,
																	// nhưng offset bđ ở 0. nên page - 1 = offset
			result.setListResult(userService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
			
		} else {
			//result.setPage(1);
			result.setListResult(userService.findAll());
			//result.setTotalPage(1);
		}
		return result;

	}
	
	@PostMapping(value = "user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return userService.save(model);
	}
	
	@PutMapping(value = "user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userService.save(model);
	}
	
	@DeleteMapping(value = "user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}