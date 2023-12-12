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

import com.ute.shop.api.output.NewsOutput;
import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;

@CrossOrigin
@RestController
public class NewsAPI {

	@Autowired
	private INewsService newsService;

	@GetMapping(value = "news") // /news?page=1&limit=2
	public NewsOutput showNews(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, 
								@RequestParam(value = "limit", required = false, defaultValue = "2") Integer limit) { //không bắt buộc có tham số
		NewsOutput result = new NewsOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit); // page: chính là offset ở repository. page bđ ở 1,
																	// nhưng offset bđ ở 0. nên page - 1 = offset
			result.setListResult(newsService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newsService.totalItem()) / limit));
			
		} else {
			//result.setPage(1);
			result.setListResult(newsService.findAll());
			//result.setTotalPage(1);
		}
		return result;

	}

	@PostMapping(value = "news")
	public NewsDTO createNews(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}

	@PutMapping(value = "news/{id}")
	public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newsService.save(model);
	}

	@DeleteMapping(value = "news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}

}
/*
 * Cơ chế Autowird/ Injection: cho phép ta nhúng đối tượng ở Repository,
 * Service, hoặc ko cụ thể
 * 
 * @Repository: ở class implement. Nhưng class này được viết sẳn và @Repository
 * sẳn
 * 
 * @Service: ở class implenment
 * 
 * @Component: ở class ko cụ thể. VD: class Newsconverter
 */

/*
 * 4 HTTP method: phải đi đúng action của nó put: update post: insert; thường
 * parameter đẩy từ body vào delete: delete get: find, display; parameter để
 * trên URL hết
 */

/*
 * 2 kiểu lấy tham số của url Request Param: ?variable=xxx
 */