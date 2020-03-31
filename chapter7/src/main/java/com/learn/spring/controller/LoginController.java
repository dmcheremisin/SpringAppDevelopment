package com.learn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String getLoginPage(@RequestParam(required = false) Boolean logoutSuccess,
                               @RequestParam(required = false) Boolean loginFailed,
                               Model model) {
        model.addAttribute("logoutSuccess", logoutSuccess);
        model.addAttribute("loginFailed", loginFailed);
        return "login";
    }

    @GetMapping("/access-denied")
    public String getLogoutPage() {
        return "error/access-denied";
    }

}
