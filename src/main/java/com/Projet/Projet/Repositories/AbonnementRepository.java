package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    Abonnement findFirst1ByCentreFormation_IdOrderByIdDesc(Long idCenter);
}
