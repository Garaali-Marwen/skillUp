package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.User;
import com.Projet.Projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login/{email}/{password}")
    public User login(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.login(email,password);
    }
}
