package com.daeduk.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeduk.dto.TestDto;
import com.daeduk.entity.TestEntity;
import com.daeduk.exception.NotFoundException;
import com.daeduk.repository.TestRepository;
import com.daeduk.service.TestService;

@Service
public class TestServiceImple implements TestService {
    
    @Autowired
    TestRepository testRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TestDto getTestValue() {

        Optional<TestEntity> testValue = testRepository.findById(1);
        TestEntity entity = testValue.orElseThrow(() -> new NotFoundException("not found any data"));

        /* entity to dto setting */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        TestDto testDto = modelMapper.map(entity, TestDto.class);

        return testDto;
    }
}
