package com.democrud.demo.controlller;

import com.democrud.demo.model.Role;
import com.democrud.demo.model.User;

import com.democrud.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAdminPage(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userService.loadUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.listAllUsers());
        return "admin";
    }

    @GetMapping(value = "/new")
    public String addNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping(value = "/new")
    public String saveNewUser(@ModelAttribute("user") User user, @RequestParam("editRoles") String[] roles) {

        Set<Role> roleList = new HashSet<>();
        for (String role : roles) {
            roleList.add(userService.getRole(role));
        }
        user.setRoles(roleList);
        userService.saveUser(user);
        return "redirect:/admin/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUserPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "admin";
    }

    @PostMapping(value = "/{id}/edit")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("editRoles") String[] roles, int id) {
        Set<Role> roleList = new HashSet<>();
        for (String r : roles) {
            roleList.add(userService.getRole(r));
        }
        User dbUser = userService.getById(id);

        if (user.getPassword().isEmpty()) {
            user.setPassword(dbUser.getPassword());

        } else if (!user.getPassword().equals(dbUser.getPassword())) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        }
        user.setRoles(roleList);
        userService.updateUser(user);
        return "redirect:/admin/";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }
}
