package com.daeduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daeduk.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer>{
    
}
