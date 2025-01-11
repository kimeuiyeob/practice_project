package com.daeduk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daeduk.entity.ProductSealEntity;

public interface ProductSealRepository extends JpaRepository<ProductSealEntity,Integer>{
    
    List<ProductSealEntity> findByProductType(String productType);
}
