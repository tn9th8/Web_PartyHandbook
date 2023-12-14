package com.ute.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class RoleDTO extends AbstracDTO<RoleDTO>{
	
	private String name;
	private String code;
	
}
