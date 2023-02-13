package com.skillup.Projet.Entities;

import com.skillup.Projet.Enum.EtatSponsoring;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Sponsoring {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated
    private EtatSponsoring etat;
    @ManyToOne
    private Formation formation;
}
