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
@Table(name = "news") // post
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsEntity extends BaseEntity {

	@Column
	private String tittle; // title VARCHAR(255) NULL,
	@Column
	private String shortDescription; // short_description TEXT NULL,
	@Column
	private String thumbnail; // thumb.nail VARCHAR(255) NULL,
	@Column
	private String content; // content TEXT NULL,
	@ManyToOne()
	@JoinColumn(name = "category_id")
    private CategoryEntity category;
}
