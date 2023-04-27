package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.TransactionClient;
import com.Projet.Projet.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
