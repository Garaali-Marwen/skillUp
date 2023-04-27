package com.Projet.Projet.Controller;

import com.Projet.Projet.Configuration.AuthenticationRequest;
import com.Projet.Projet.Configuration.AuthenticationResponse;
import com.Projet.Projet.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping("/authenticate")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request){
        return userService.login(request);
    }


}
