package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.CentreFormation;

import java.util.List;

public interface CentreFormationService {
    CentreFormation addCentre(CentreFormation centreFormation);
    List<CentreFormation> getAllCentreFormation();
    void deleteCentreFormation(Long id) ;
    CentreFormation getCentreFormationById(Long id);

}
