package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TransactionCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String heure;
    @OneToOne(mappedBy = "transaction")
    private Abonnement abonnement;
    @ManyToOne
    private CentreFormation centreFormation;
}
