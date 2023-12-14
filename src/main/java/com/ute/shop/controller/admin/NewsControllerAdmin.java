package com.ute.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ute.shop.dto.NewsDTO;
import com.ute.shop.service.INewsService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/news")
public class NewsControllerAdmin {

	@Autowired
	INewsService newsService;

	@GetMapping("list") // URL
	public String list(ModelMap model) {
		List<NewsDTO> newsDTOs = newsService.findAllByOrderByIdDesc();
		model.addAttribute("newss", newsDTOs);
		return "admin-ace/news/list"; // HTML
	}

	@GetMapping("add")
	public String add(Model model) {
		NewsDTO newsDTO = new NewsDTO();
		model.addAttribute("news", newsDTO);
		return "admin-ace/news/edit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {

		NewsDTO newsDTO = newsService.findById(id);
		model.addAttribute("news", newsDTO);
		return new ModelAndView("admin-ace/news/edit", model);
	}

	@PostMapping("save")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("news") NewsDTO newsDTO, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin-ace/news/edit");
		}
		newsService.save(newsDTO);
		model.addAttribute("message", "The news is saved!!!!!!!!");
		return new ModelAndView("forward:/admin/news/list", model);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		newsService.deleteById(id);
		model.addAttribute("message", "The news is deleted!!!!");
		return new ModelAndView("forward:/admin/news/list", model); // redirect:
	}

}
