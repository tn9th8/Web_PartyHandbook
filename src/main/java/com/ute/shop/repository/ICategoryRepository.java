package com.ute.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ute.shop.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code); //find single
}
