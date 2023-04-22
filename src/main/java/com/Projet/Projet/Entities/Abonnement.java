package com.Projet.Projet.Entities;

import com.Projet.Projet.Enum.TypeAbonnement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private TypeAbonnement type;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToOne
    @JsonManagedReference
    private CentreFormation centreFormation;
    @OneToOne
    @JsonBackReference
    private TransactionCentre transaction;

}

