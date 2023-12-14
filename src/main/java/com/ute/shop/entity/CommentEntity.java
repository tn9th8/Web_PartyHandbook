package com.ute.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment") // post
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CommentEntity extends BaseEntity{
	
	@Column
	private String content;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserEntity user;
	@ManyToOne()
	@JoinColumn(name = "news_id")
	private NewsEntity news;
	  
}
