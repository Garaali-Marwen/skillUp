package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
public class Manager extends User {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<CentreFormation> centreFormation = new ArrayList<>();
}
