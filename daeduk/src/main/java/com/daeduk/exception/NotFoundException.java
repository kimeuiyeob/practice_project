package com.daeduk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daeduk.service.impl.UserServiceImpl;

public class NotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public NotFoundException(String message) {
        super(message);
        logger.info("NotFoundException : {}", message);
    }

}