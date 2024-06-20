package com.daeduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daeduk.dto.TestDto;
import com.daeduk.service.TestService;

@Controller
public class TestController {

    @Autowired
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public String index(Model model) {

        TestDto testDto = testService.getTestValue();
        model.addAttribute("message", testDto.getCustName());
        return "test";
    }

    @GetMapping("/sidebar")
    public String sidebar() {
        return "sidebar";
    }

}
