package com.daeduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Hello, Daeduk!");
        return "index";
    }

    /* 인덱스 */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /* 회사소개 */
    @GetMapping("/companyIntroduce")
    public String companyIntroduce() {
        return "companyIntroduce";
    }

    /* 제품 안내 */
    @GetMapping("/introduceProduct")
    public String introduceProduct() {
        return "introduceProduct";
    }
}
