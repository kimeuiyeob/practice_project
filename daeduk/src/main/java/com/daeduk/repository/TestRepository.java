package com.daeduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daeduk.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity,Integer>{
    
}
