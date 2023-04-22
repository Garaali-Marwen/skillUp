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
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;
    private String img;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prix;
    private Integer nbMaxCan;

    @ManyToOne
    @JsonBackReference
    private CentreFormation centreFormation;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonManagedReference
    private List<Avis> avis = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonManagedReference
    private List<Offre> offres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonManagedReference
    private List<Seance> seances = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "formation_formateur",
            joinColumns =  @JoinColumn(name = "formation_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "formateur_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Formateur> formateurs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonManagedReference
    private List<Sponsoring> sponsorings;

    @ManyToOne
    @JsonBackReference
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonBackReference
    private List<DemandeInscription> demandes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    @JsonBackReference
    private List<TransactionClient> transactionClients = new ArrayList<>();

    @ManyToMany(mappedBy = "formations")
    @JsonBackReference
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(mappedBy = "formations")
    @JsonBackReference
    private List<Tag> tags = new ArrayList<>();
}
