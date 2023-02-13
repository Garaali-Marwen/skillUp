package com.skillup.Projet.Services;

import com.skillup.Projet.Entities.Formation;

import java.util.List;

public interface FormationService {

    public Formation addFormation(Formation formation);
    public List<Formation> getAllFormations();


}
