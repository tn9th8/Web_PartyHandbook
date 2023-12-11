package com.ute.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ute.shop.entity.NewsEntity;

@Repository
public interface INewsRepository extends JpaRepository<NewsEntity, Long> {

}
