package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.TransactionClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionClientRepository extends JpaRepository<TransactionClient,Long> {
}
