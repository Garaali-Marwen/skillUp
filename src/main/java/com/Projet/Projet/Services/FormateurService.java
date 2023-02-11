package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.Formateur;

import java.util.List;
import java.util.Optional;

public interface FormateurService {
    public Formateur addFormateur(Optional<Formateur> formateur);
    public List<Formateur> getAllFormateurs();

    Optional<Formateur> getFormateurById(Long id);
}
