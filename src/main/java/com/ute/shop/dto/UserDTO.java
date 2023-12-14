package com.ute.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class UserDTO extends AbstracDTO<UserDTO> {
	
	private String userName;
	private String fullname;
	private String password;
	private Integer status;
	
}
