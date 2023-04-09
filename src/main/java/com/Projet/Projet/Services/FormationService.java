package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.Formation;

import java.util.List;

public interface FormationService {

    Formation addFormation(Formation formation);
    List<Formation> getAllFormations();
    Formation getFormationById(Long formationId);
    Formation updateFormation(Formation formation);
    void deleteFormation(Long formationId);
    Formation addSeanceToFormation(Long seanceId, Long formationId);
    List<Formation> getFormationByTitre(String titre);
    List<Formation> getFormationByPrixBetween(double prix1, double prix2);
    List<Formation> getFormationsByCategorie_Id(Long categorieId);
    List<Formation> getFormationsByPrixBetweenAndCategorie_Id(double prix1, double prix2, Long categorieId);


    Formation addFormateurToFormation(Long formateurId, Long formationId);
    Formation addOffreToFormation(Long oid, Long formationId);
}
