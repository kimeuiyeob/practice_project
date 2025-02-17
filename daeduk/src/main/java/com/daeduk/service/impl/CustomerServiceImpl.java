package com.daeduk.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeduk.dto.CustomerDto;
import com.daeduk.entity.CustomerEntity;
import com.daeduk.exception.NotFoundException;
import com.daeduk.repository.CustomerRepository;
import com.daeduk.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto getTestValue() {

        Optional<CustomerEntity> testValue = customerRepository.findById(1);
        CustomerEntity entity = testValue.orElseThrow(() -> new NotFoundException("Data not found for ID: 1"));

        CustomerDto testDto = modelMapper.map(entity, CustomerDto.class);

        return testDto;
    }
}
