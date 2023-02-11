package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Repositories.FomateurRespository;
import com.Projet.Projet.Services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurSerrviceImpl implements FormateurService {

    @Autowired
    private FomateurRespository fomateurRespository;


    @Override
    public Formateur addFormateur(Formateur formateur) {
        return fomateurRespository.save(formateur);
    }

    @Override
    public Formateur addFormateur(Optional<Formateur> formateur) {
        return fomateurRespository.save(formateur);
    }

    @Override
    public List<Formateur> getAllFormateurs() {
        return fomateurRespository.findAll();
    }

    @Override
    public Optional<Formateur> getFormateurById(Long id) {
        return fomateurRespository.findById(id);
    }
}
