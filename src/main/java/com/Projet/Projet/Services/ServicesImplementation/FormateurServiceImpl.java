package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Repositories.FormateurRespository;
import com.Projet.Projet.Services.FormateurService;
import com.Projet.Projet.Services.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormateurServiceImpl implements FormateurService {


    private FormateurRespository formateurRespository;
    private FormationService formationService;

    @Override
    public List<Formateur> getAllFormateurs() {
        return formateurRespository.findAll();
    }

    @Override
    public Formateur getFormateurById(Long id) {
        return formateurRespository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Aucun formateur trouvé"));
    }

    @Override
    public Formateur addFormateur(Formateur formateur) {
        return formateurRespository.save(formateur);
    }

    @Override
    public Formateur addFormateur(Optional<Formateur> formateur) {
        return null;
    }



     public Formateur updateFormateur(Long id, Formateur formateur){
        Formateur newFormateur = getFormateurById(id);

         newFormateur.setNom(formateur.getNom());
         newFormateur.setPrenom(formateur.getPrenom());
         newFormateur.setEmail(formateur.getEmail());
         newFormateur.setPhoto(formateur.getPhoto());

         formateurRespository.save(formateur);

         return newFormateur;
    }

    @Override
    public void deleteFormateur(Long id) {
        formateurRespository.deleteById(id);
    }

    @Override
    public Formateur addFormateurToFormation(Long formateurId, Long formationId) {
        Formateur formateur=getFormateurById(formateurId);
        Formation formation=formationService.getFormationById(formationId);
        formateur.getFormations().add(formation);
        updateFormateur(formateurId,formateur);
        formation.getFormateurs().add(formateur);
        formationService.updateFormation(formation);
        return formateur;
    }
}
