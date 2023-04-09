package com.Projet.Projet.Repositories;

import com.Projet.Projet.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> getFormationByTitre(String titre);
    List<Formation> getFormationByPrixBetween(double prix1, double prix2);
    List<Formation> getFormationsByCategorie_Id(Long categorieId);
    List<Formation> getFormationsByPrixBetweenAndCategorie_Id(double prix1, double prix2, Long categorieId);
}
