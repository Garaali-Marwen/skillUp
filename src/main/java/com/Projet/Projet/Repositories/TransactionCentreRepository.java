package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.TransactionCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionCentreRepository extends JpaRepository<TransactionCentre, Long> {

    List<TransactionCentre> getTransactionCentresByCentreFormation_Manager_Id(Long managerId);
}
