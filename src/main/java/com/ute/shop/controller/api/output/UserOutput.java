package com.ute.shop.controller.api.output;

import java.util.ArrayList;
import java.util.List;

import com.ute.shop.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOutput {

	private int page;
	private int totalPage;
	private List<UserDTO> listResult = new ArrayList<UserDTO>();
}