package com.Projet.Projet.Services;

import com.Projet.Projet.Configuration.AuthenticationRequest;
import com.Projet.Projet.Configuration.AuthenticationResponse;
import com.Projet.Projet.Entities.User;

public interface UserService{

    AuthenticationResponse login(AuthenticationRequest request);
    User lockAccount(Long userId);

}
