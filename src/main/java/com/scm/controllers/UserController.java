package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {
    @GetMapping("dashboard")
    public String dashboard() {
        return "pages/users/dashboard";
    }

    @GetMapping("profile")
    public String profile() {
        return "pages/users/profile";
    }
}
