package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findClientsByFormations_Id(Long formationId);
}
