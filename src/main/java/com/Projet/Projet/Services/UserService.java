package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.User;

public interface UserService {

    User login(String email, String password);
}
