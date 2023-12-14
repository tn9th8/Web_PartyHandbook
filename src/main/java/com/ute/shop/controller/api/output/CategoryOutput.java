package com.ute.shop.controller.api.output;

import java.util.ArrayList;
import java.util.List;

import com.ute.shop.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryOutput {

	private int page;
	private int totalPage;
	private List<CategoryDTO> listResult = new ArrayList<CategoryDTO>();
}