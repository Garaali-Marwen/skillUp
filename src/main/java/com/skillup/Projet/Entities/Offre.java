package com.skillup.Projet.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int remise;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToOne
    private Formation formation;
    @ManyToOne
    private CentreFormation centreFormation;

}
