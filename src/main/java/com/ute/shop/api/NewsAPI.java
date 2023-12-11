package com.ute.shop.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;

@CrossOrigin
@RestController
public class NewsAPI {
	
	@Autowired
	private INewsService newsService;
	
    @PostMapping(value = "news")
    public NewsDTO createNews(@RequestBody NewsDTO model) {
           return newsService.save(model);
    }	
	
    @PutMapping(value = "news/{id}")
    public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id ) {
    	model.setId(id);
    	return newsService.save(model);
    }
    
    @DeleteMapping(value = "news")
    public void deleteNews(@RequestBody long[] ids) {

    }    
}
/*
 * Cơ chế Autowird/ Injection: 
 * cho phép ta nhúng đối tượng ở Repository, Service, hoặc ko cụ thể
 * @Repository: ở class implement. Nhưng class này được viết sẳn và @Repository sẳn
 * @Service: ở class implenment
 * @Component: ở class ko cụ thể. VD: class Newsconverter
 */


/*
 * 4 HTTP method: phải đi đúng action của nó
 * put: update
 * post: insert
 * delete: delete
 * get: find, display
 */

/*
 * 2 kiểu lấy tham số của url
 * Request Param: ?variable=xxx
 */