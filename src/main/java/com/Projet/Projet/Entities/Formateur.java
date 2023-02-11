package com.Projet.Projet.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    @ManyToMany(mappedBy = "formateurs")
    private List<Formation> formations = new ArrayList<>();
}
