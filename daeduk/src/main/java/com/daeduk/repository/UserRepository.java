package com.daeduk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daeduk.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

    public Optional<UserEntity> findByEmail(String email);
} 
