package com.daeduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
    @ModelAttribute
    public void checkLogin(Model model, HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        model.addAttribute("loginCheck", userEmail != null);
    }
}
