package com.skillup.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class CentreFormation extends User{

    private String nom;
    private String adresse;
    private int tel;
    private String email;
    private long rib;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "centreFormation")
    private List<Formation> formations = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "centreFormation")
    private List<Abonnement> abonnements = new ArrayList<>();
    @OneToMany
    private List<Offre> offres = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<TransactionCentre> transactions = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "centreFormation")
    private List<Notification> notifications = new ArrayList<>();

    //transaction sponsoring, transaction client,
    //test
}
