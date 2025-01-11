package com.daeduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daeduk.dto.ProductSealDto;
import com.daeduk.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController extends SessionController {

    @Autowired
    private ProductService productService;

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
    public String introduceProduct(Model model) {

        List<ProductSealDto> saltSeal = productService.getProductSaltSeal();
        List<ProductSealDto> trackSeal = productService.getProductTrackSeal();

        model.addAttribute("saltSeal", saltSeal);
        model.addAttribute("trackSeal", trackSeal);

        return "introduceProduct";
    }

    /* 제품 설비 */
    @GetMapping("/manufacture")
    public String manufacture() {
        return "manufacture";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
