package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Entities.Offre;
import com.Projet.Projet.Entities.Seance;
import com.Projet.Projet.Repositories.ClientRepository;
import com.Projet.Projet.Repositories.FormationRepository;
import com.Projet.Projet.Repositories.TagRepository;
import com.Projet.Projet.Services.FormateurService;
import com.Projet.Projet.Services.FormationService;
import com.Projet.Projet.Services.OffreService;
import com.Projet.Projet.Services.SeanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private FormationRepository formationRepository;
    //private FormationService formationService;
    private SeanceService seanceService;
    private ClientRepository clientRepository;
    private OffreService offreService;
    private TagRepository tagRepository;
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
        tagRepository.getTagsByFormations_Id(formationId).forEach(tag -> tag.getFormations().remove(formation));
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
    public List<Formation> getFormationByTitre(String titre) {
        return formationRepository.getFormationByTitre(titre);
    }

    @Override
    public List<Formation> getFormationByPrixBetween(double prix1, double prix2) {
        return formationRepository.getFormationByPrixBetween(prix1, prix2);
    }

    @Override
    public List<Formation> getFormationsByCategorie_Id(Long categorieId) {
        return formationRepository.getFormationsByCategorie_Id(categorieId);
    }

    @Override
    public List<Formation> getFormationsByPrixBetweenAndCategorie_Id(double prix1, double prix2, Long categorieId) {
        return formationRepository.getFormationsByPrixBetweenAndCategorie_Id(prix1, prix2, categorieId);
    }

    @Override
    public List<Formation> getFormationByTag(String tag) {
        return formationRepository.getFormationByTags_Nom(tag);
    }

    @Override
    public List<Formation> getFormationsByCentreFormation_Id(Long centerId) {
        return formationRepository.getFormationsByCentreFormation_Id(centerId);
    }

    @Override
    public List<Formation> getFormationsByTagNameOrTitle(String param) {
        return formationRepository.findByTagNameOrTitle(param);
    }

    @Override
    public Formation addFormateurToFormation(Long formateurId, Long formationId) {
        Formation formation = getFormationById(formationId);
        Formateur formateur = formateurService.getFormateurById(formateurId);

        formation.getFormateurs().add(formateur);

        updateFormation(formation);

        formateur.getFormations().add(formation);
        formateurService.updateFormateur(formateurId, formateur);

        return formation;
    }


    public Formation addOffreToFormation(Long oid, Long fid) {
        Offre offre = offreService.getOfferById(oid);
        Formation formation = getFormationById(fid);

        formation.getOffres().add(offre);
        updateFormation(formation);

        offre.setFormation(formation);

        return formation;
    }
}