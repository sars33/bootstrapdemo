package com.democrud.demo.controlller;

import com.democrud.demo.model.User;
import com.democrud.demo.repositories.UserRepository;
import com.democrud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UsersController {

    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String printWelcome(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userService.loadUserByUsername(name);
        model.addAttribute("user", user);
        return "user";
    }
}
