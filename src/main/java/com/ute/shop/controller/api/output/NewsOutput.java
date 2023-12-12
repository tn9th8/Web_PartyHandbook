package com.ute.shop.controller.api.output;

import java.util.ArrayList;
import java.util.List;

import com.ute.shop.dto.NewsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsOutput {
	private int page;
	private int totalPage;
	private List<NewsDTO> listResult = new ArrayList<NewsDTO>();
}
