package com.skillup.Projet.Services;

import com.skillup.Projet.Entities.Formateur;

import java.util.List;
import java.util.Optional;

public interface FormateurService {

    List<Formateur> getAllFormateurs();
    Optional<Formateur> getFormateurById(Long id);
    Formateur addFormateur(Formateur formateur);
    Formateur addFormateur(Optional<Formateur> formateur);
    Optional<Formateur> updateFormateur(Long id, Formateur formateur);
     void deleteFormateur(Long id);
}
