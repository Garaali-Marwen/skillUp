package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Repositories.FormateurRespository;
import com.Projet.Projet.Services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurServiceImpl implements FormateurService {

    @Autowired
    FormateurRespository formateurRespository;

    @Override
    public List<Formateur> getAllFormateurs() {
        return formateurRespository.findAll();
    }

    @Override
    public Optional<Formateur> getFormateurById(Long id) {
        return formateurRespository.findById(id);
    }

    @Override
    public Formateur addFormateur(Formateur formateur) {
        return formateurRespository.save(formateur);
    }

    @Override
    public Formateur addFormateur(Optional<Formateur> formateur) {
        return null;
    }



     public Optional<Formateur> updateFormateur(Long id, Formateur formateur){
        Optional<Formateur> newFormateur = getFormateurById(id);

         newFormateur.get().setNom(formateur.getNom());
         newFormateur.get().setPrenom(formateur.getPrenom());
         newFormateur.get().setEmail(formateur.getEmail());
         newFormateur.get().setPhoto(formateur.getPhoto());

         formateurRespository.save(formateur);

         return newFormateur;
    }

    @Override
    public void deleteFormateur(Long id) {
        formateurRespository.deleteById(id);
    }
}
