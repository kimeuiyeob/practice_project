package com.daeduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController extends SessionController {

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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
