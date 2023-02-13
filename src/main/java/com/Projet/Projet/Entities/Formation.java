package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sujet;
    private String lieu;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prix;
    @ManyToOne
    private CentreFormation centreFormation;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<Avis> avis = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<Offre> offres = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<Seance> seances = new ArrayList<>();
    @ManyToMany()
    @JoinTable(
            name = "formation_formateur",
            joinColumns =  @JoinColumn(name = "formation_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "formateur_id", referencedColumnName = "id"))
    private List<Formateur> formateurs = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<Sponsoring> sponsorings;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<DemandeInscription> demandes = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "formation")
    private List<TransactionClient> transactionClients = new ArrayList<>();
    @ManyToMany(mappedBy = "formations")
    private List<Client> clients = new ArrayList<>();


}
