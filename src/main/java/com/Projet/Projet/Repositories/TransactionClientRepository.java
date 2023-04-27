package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.TransactionClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionClientRepository extends JpaRepository<TransactionClient,Long> {
    List<TransactionClient> findTransactionClientByClient_Id(Long clientId);

}
