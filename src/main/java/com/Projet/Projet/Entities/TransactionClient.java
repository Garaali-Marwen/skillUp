package com.Projet.Projet.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TransactionClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String heure;
    private double valeur;
    @ManyToOne
    @JsonManagedReference
    private Client client;
    @ManyToOne
    @JsonManagedReference
    private Formation formation;
}
