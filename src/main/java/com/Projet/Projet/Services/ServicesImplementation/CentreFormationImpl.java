package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Enum.Role;
import com.Projet.Projet.Repositories.CentreFormationRepository;
import com.Projet.Projet.Services.CentreFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public String deleteCentreFormation(final Long id) {
        CentreFormation centreFormation=centreFormationRepository.findById(id).orElse(null);
        if(centreFormation!=null){
            centreFormationRepository.delete(centreFormation);
            return "centre supprimé avec succé";
        }else
            return "centre n'existe pas";


    }

    @Override
    public CentreFormation getCentreFormationById(Long id) {
        return centreFormationRepository.findById(id).orElseThrow(()-> new NoSuchElementException(
                "NO Centre PRESENT WITH ID = " + id));
    }

    @Override
    public CentreFormation updateCentreFormation(CentreFormation centreFormation) {
        if(!centreFormationRepository.existsById(centreFormation.getId())){
            throw new NoSuchElementException("centre n'existe pas avec l'id"+centreFormation.getId());
        }
        return centreFormationRepository.save(centreFormation);
    }
}
