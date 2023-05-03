package com.training360.tdd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<String> users = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        users.add(user.getName());
        return "redirect:/";
    }

    public static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
