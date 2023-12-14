package com.ute.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class CategoryDTO extends AbstracDTO<CategoryDTO> {
	
	private String name;
	private String code;
	
	
}
