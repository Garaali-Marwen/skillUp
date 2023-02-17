package com.Projet.Projet.Entities;

import com.Projet.Projet.Enum.TypeAbonnement;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private TypeAbonnement type;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToOne
    private CentreFormation centreFormation;
    @OneToOne
    private TransactionCentre transaction;

}

