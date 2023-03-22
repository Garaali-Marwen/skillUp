package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.User;
import com.Projet.Projet.Repositories.UserRepository;
import com.Projet.Projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getMdp().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
