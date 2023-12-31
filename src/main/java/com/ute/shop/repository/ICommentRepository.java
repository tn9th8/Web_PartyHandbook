package com.ute.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ute.shop.entity.CommentEntity;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {

}