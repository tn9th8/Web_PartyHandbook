package com.ute.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ute.shop.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}