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

import com.ute.shop.controller.api.output.CategoryOutput;
import com.ute.shop.dto.CategoryDTO;
import com.ute.shop.service.ICategoryService;


@CrossOrigin
@RestController
public class CategoryAPI {

	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping(value = "category") // /news?page=1&limit=2
	public CategoryOutput showCategory(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
								@RequestParam(value = "limit", required = false, defaultValue = "2") Integer limit) { //không bắt buộc có tham số
		CategoryOutput result = new CategoryOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit); // page: chính là offset ở repository. page bđ ở 1,
																	// nhưng offset bđ ở 0. nên page - 1 = offset
			result.setListResult(categoryService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (categoryService.totalItem()) / limit));
			
		} else {
			//result.setPage(1);
			result.setListResult(categoryService.findAll());
			//result.setTotalPage(1);
		}
		return result;

	}
	
	@PostMapping(value = "category")
	public CategoryDTO createCategory(@RequestBody CategoryDTO model) {
		return categoryService.save(model);
	}
	
	@PutMapping(value = "category/{id}")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return categoryService.save(model);
	}
	
	@DeleteMapping(value = "category")
	public void deleteNews(@RequestBody long[] ids) {
		categoryService.delete(ids);
	}
}