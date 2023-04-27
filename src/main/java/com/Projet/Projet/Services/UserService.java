package com.Projet.Projet.Services;

import com.Projet.Projet.Configuration.AuthenticationRequest;
import com.Projet.Projet.Configuration.AuthenticationResponse;

public interface UserService{

    AuthenticationResponse login(AuthenticationRequest request);

}
