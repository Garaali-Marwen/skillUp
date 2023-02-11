package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Repositories.FormationRepository;
import com.Projet.Projet.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;


    @Override
    public Formation addFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }
}