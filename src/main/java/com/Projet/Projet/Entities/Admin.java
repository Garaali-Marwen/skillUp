package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Admin extends User{


    private String nom;
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Notification> notifications = new ArrayList<>();
}
