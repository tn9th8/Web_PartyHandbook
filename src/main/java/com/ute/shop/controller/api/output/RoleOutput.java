package com.ute.shop.controller.api.output;

import java.util.ArrayList;
import java.util.List;

import com.ute.shop.dto.RoleDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleOutput {

	private int page;
	private int totalPage;
	private List<RoleDTO> listResult = new ArrayList<RoleDTO>();
}