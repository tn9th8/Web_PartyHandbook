package com.ute.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class CommentDTO extends AbstracDTO<CommentDTO> {
	
	private String content; //content TEXT NOT NULL,
	private Long userId; //user_id bigint NOT NULL,
	private Long newsId; //new_id bigint NOT NULL,
}
