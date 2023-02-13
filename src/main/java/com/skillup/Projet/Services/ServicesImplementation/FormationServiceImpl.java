package com.skillup.Projet.Services.ServicesImplementation;

import com.skillup.Projet.Entities.Formation;
import com.skillup.Projet.Repositories.FormationRepository;
import com.skillup.Projet.Services.FormationService;
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