package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie getCategorieByNom(String nom);
    Categorie getCategorieByFormations_Id(Long id);

    @Query("SELECT count(*) FROM Categorie")
    int getCategoriesNumber();

    @Query("SELECT DISTINCT c FROM Categorie c JOIN c.formations f WHERE SIZE(c.formations) > 0")
    List<Categorie> getNotNullCategories();

}
