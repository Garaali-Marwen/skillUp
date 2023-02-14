package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.Abonnement;

import java.util.List;
import java.util.Optional;

public interface AbonnementService {

    List<Abonnement> getAllAbonnements();
    Abonnement getAbonnementById(Long id);
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement editAbonnement(Long id, Abonnement abonnement);
    void deleteAbonnement(Long id);
}
