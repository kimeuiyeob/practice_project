package com.daeduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daeduk.dto.CustomerDto;
import com.daeduk.service.CustomerService;

@Controller
public class TestController {

    @Autowired
    private final CustomerService testService;

    @Autowired
    public TestController(CustomerService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public String index(Model model) {

        CustomerDto testDto = testService.getTestValue();
        model.addAttribute("message", testDto.getCustName());
        return "test";
    }

    @GetMapping("/sidebar")
    public String sidebar() {
        return "sidebar";
    }

}
