package com.ute.shop.controller.api.output;

import java.util.ArrayList;
import java.util.List;

import com.ute.shop.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentOutput {

	private int page;
	private int totalPage;
	private List<CommentDTO> listResult = new ArrayList<CommentDTO>();
}