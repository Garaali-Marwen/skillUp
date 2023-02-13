package com.skillup.Projet.Services;

import com.skillup.Projet.Entities.Abonnement;

import java.util.List;
import java.util.Optional;

public interface AbonnementService {

    List<Abonnement> getAllAbonnements();
    Optional<Abonnement> getAbonnementById(Long id);
    Abonnement addAbonnement(Abonnement abonnement);
    Optional<Abonnement> editAbonnement(Long id, Abonnement abonnement);
    void deleteAbonnement(Long id);
}
