package com.practice.controller;

import com.practice.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secret")
public class SecretController {
    private final LoggedUserManagementService loggedUserManagementService;

    public SecretController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping
    public String secretGet(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if (logout != null) this.loggedUserManagementService.setUsername(null);

        String username = this.loggedUserManagementService.getUsername();

        if (username == null) return "redirect:/login";

        model.addAttribute("username", username);

        return "secret";
    }
}
