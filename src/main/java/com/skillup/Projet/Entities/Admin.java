package com.skillup.Projet.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Admin extends User{


    private String nom;//ali test
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();
}
