package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Entities.Seance;
import com.Projet.Projet.Repositories.ClientRepository;
import com.Projet.Projet.Repositories.FormationRepository;
import com.Projet.Projet.Services.FormateurService;
import com.Projet.Projet.Services.FormationService;
import com.Projet.Projet.Services.SeanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private FormationRepository formationRepository;
    private SeanceService seanceService;
    private ClientRepository clientRepository;

    private FormateurService formateurService;


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
        Formation formation = getFormationById(formationId);
        clientRepository.findClientsByFormations_Id(formationId).forEach(client -> client.getFormations().remove(formation));
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

    @Override
    public Formation addFormateurToFormation(Long formateurId, Long formationId){
        Formation formation = getFormationById(formationId);
        Formateur formateur = formateurService.getFormateurById(formateurId);

        formation.getFormateurs().add(formateur);

        updateFormation(formation);

        formateur.getFormations().add(formation);
        formateurService.updateFormateur(formateurId,formateur);

        return formation;
    }

}