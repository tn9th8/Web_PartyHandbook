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

import com.ute.shop.controller.api.output.CommentOutput;
import com.ute.shop.dto.CommentDTO;
import com.ute.shop.service.ICommentService;

@CrossOrigin
@RestController
public class CommentAPI {

	@Autowired
	private ICommentService commentService;

	@GetMapping(value = "comment") // /news?page=1&limit=2
	public CommentOutput showComment(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
								@RequestParam(value = "limit", required = false, defaultValue = "2") Integer limit) { //không bắt buộc có tham số
		CommentOutput result = new CommentOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit); // page: chính là offset ở repository. page bđ ở 1,
																	// nhưng offset bđ ở 0. nên page - 1 = offset
			result.setListResult(commentService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (commentService.totalItem()) / limit));
			
		} else {
			//result.setPage(1);
			result.setListResult(commentService.findAll());
			//result.setTotalPage(1);
		}
		return result;

	}

	@PostMapping(value = "comment")
	public CommentDTO createCommnent(@RequestBody CommentDTO model) {
		return commentService.save(model);
	}

	@PutMapping(value = "comment/{id}")
	public CommentDTO updateCommnent(@RequestBody CommentDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return commentService.save(model);
	}

	@DeleteMapping(value = "comment")
	public void deleteComment(@RequestBody long[] ids) {
		commentService.delete(ids);
	}
}