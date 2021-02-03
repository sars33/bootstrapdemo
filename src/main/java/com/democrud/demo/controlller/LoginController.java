package com.democrud.demo.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/")
    public String returnHomePage() {
        return "login";
    }

    @GetMapping(value = "login")
    public String getLoginPage() {
        return "login";
    }
}