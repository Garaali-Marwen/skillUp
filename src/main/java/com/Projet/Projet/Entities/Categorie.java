package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Formation> formations = new ArrayList<>();
    @ManyToMany(mappedBy = "categorie")
    private List<CentreFormation> centreFormations = new ArrayList<>();
}
