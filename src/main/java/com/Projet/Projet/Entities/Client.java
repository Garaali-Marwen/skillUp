package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client extends User{

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int tel;
    private String adresse;
    private String fonction;
    @ManyToMany
    @JoinTable(
            name = "client_formation",
            joinColumns =  @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "formation_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Formation> formations = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "client")
    @JsonBackReference
    private List<DemandeInscription> demandeInscriptions = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "client")
    @JsonBackReference
    private List<TransactionClient> transactions = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "client")
    @JsonBackReference
    private List<Avis> avis = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "client")
    @JsonBackReference
    private List<Notification> notifications = new ArrayList<>();
}
