package com.daeduk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeduk.dto.ProductSealDto;
import com.daeduk.entity.ProductSealEntity;
import com.daeduk.repository.ProductSealRepository;
import com.daeduk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ProductSealRepository productSealRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductSealDto> getProductSaltSeal() {

        List<ProductSealEntity> productList = productSealRepository.findByProductType("SALT SEAL");
        List<ProductSealDto> productSealDtos = new ArrayList<>();

        for (ProductSealEntity entity : productList) {
            ProductSealDto dto = modelMapper.map(entity, ProductSealDto.class);
            productSealDtos.add(dto);
        }

        return productSealDtos;
    }

    public List<ProductSealDto> getProductTrackSeal() {

        List<ProductSealEntity> productList = productSealRepository.findByProductType("TRACK SEAL");
        List<ProductSealDto> productSealDtos = new ArrayList<>();

        for (ProductSealEntity entity : productList) {
            ProductSealDto dto = modelMapper.map(entity, ProductSealDto.class);
            productSealDtos.add(dto);
        }

        return productSealDtos;
    }
}
