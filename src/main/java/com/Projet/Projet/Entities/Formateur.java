package com.Projet.Projet.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Formateur extends User{
    private String nom;
    private String prenom;
    private String email;
    private String photo;
    @ManyToMany(mappedBy = "formateurs")
    private List<Formation> formations = new ArrayList<>();
}
