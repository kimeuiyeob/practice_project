package com.daeduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DaedukController extends SessionController {

    @GetMapping("/daeduk")
    public String index(Model model) {

        String userEmail = (String) model.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/";
        }
        model.addAttribute("message", "Hello, " + userEmail + "!");
        return "daeduk";
    }
}
