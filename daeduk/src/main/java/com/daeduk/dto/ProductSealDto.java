package com.daeduk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSealDto {
 
    private Integer id;
    private String productType;
    private String productName;
    private String productStandard;
}
