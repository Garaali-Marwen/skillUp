package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Entities.Seance;
import com.Projet.Projet.Repositories.FormationRepository;
import com.Projet.Projet.Services.FormationService;
import com.Projet.Projet.Services.SeanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private FormationRepository formationRepository;
    private SeanceService seanceService;


    @Override
    public Formation addFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long formationId) {
        return formationRepository.findById(formationId).orElseThrow(
                () -> new NoSuchElementException("Aucune formation avec ID: " + formationId));
    }

    @Override
    public Formation updateFormation(Formation formation) {
        if (!formationRepository.existsById(formation.getId())) {
            throw new NoSuchElementException("Aucune formation avec ID : " + formation.getId());
        }
        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(Long formationId) {
        formationRepository.deleteById(formationId);
    }

    @Override
    public Formation addSeanceToFormation(Long seanceId, Long formationId) {
        Seance seance = seanceService.getSeanceById(seanceId);
        Formation formation = getFormationById(formationId);
        formation.getSeances().add(seance);
        formationRepository.save(formation);
        seance.setFormation(formation);
        seanceService.updateSeance(seance);
        return formation;
    }

}