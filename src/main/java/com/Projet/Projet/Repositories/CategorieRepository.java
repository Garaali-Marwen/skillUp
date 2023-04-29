package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie getCategorieByNom(String nom);
    Categorie getCategorieByFormations_Id(Long id);
}
