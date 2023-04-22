package com.Projet.Projet.Entities;

import com.Projet.Projet.Enum.EtatNotification;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contenu;
    private LocalDate date;
    @Enumerated
    private EtatNotification etat;
    @ManyToOne
    @JsonManagedReference
    private Client client;
    @ManyToOne
    @JsonManagedReference
    private CentreFormation centreFormation;
    @ManyToOne
    @JsonManagedReference
    private Admin admin;

}
