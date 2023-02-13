package com.skillup.Projet.Services;

import com.skillup.Projet.Entities.Formation;

import java.util.List;

public interface FormationService {

    Formation addFormation(Formation formation);
    List<Formation> getAllFormations();
    Formation getFormationById(Long formationId);
    Formation updateFormation(Formation formation);
    void deleteFormation(Long formationId);
    Formation addSeanceToFormation(Long seanceId, Long formationId);


}
