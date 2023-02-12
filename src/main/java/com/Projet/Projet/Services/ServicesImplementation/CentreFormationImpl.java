package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Repositories.CentreFormationRepository;
import com.Projet.Projet.Services.CentreFormationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreFormationImpl implements CentreFormationService {
    @Autowired
    private  CentreFormationRepository centreFormationRepository;
    @Override
    public CentreFormation addCentre(CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);
    }

    @Override
    public List<CentreFormation> getAllCentreFormation() {
        return centreFormationRepository.findAll();
    }

    @Override
    public void deleteCentreFormation(final Long id) {
            centreFormationRepository.deleteById(id);
    }

    @Override
    public CentreFormation getCentreFormationById(Long id) {
        return centreFormationRepository.findById(id).orElseThrow();
    }


}
