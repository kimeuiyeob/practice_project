package com.daeduk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_seal")
public class ProductSealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_standard")
    private String productStandard;

}
