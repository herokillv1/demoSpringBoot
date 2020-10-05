package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }
    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }
    @GetMapping("/admin/hihi")
    public String getHiPage() {
        return "hihi";
    }
}
