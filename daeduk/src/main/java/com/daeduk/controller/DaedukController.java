package com.daeduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DaedukController {
    
    @GetMapping("/daeduk")
    public String index(Model model) {
        model.addAttribute("message", "Hello, Daeduk!");
        return "daeduk";
    }
}
