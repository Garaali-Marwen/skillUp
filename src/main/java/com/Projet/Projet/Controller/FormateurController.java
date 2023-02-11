package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Formateur;
import com.Projet.Projet.Services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formateur")
public class FormateurController {

    @Autowired
    private FormateurService formateurService;

    @GetMapping("")
    public List<Formateur> getAllFormateurs(){
        return formateurService.getAllFormateurs();
    }

    @PostMapping("/add")
    public Optional<Formateur> addFormateur(@RequestBody Optional<Formateur> formateur){
        return formateurService.addFormateur(formateur);
    }

    @PutMapping("/edit/{id}")
    public Optional<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        Optional<Formateur> updateFormateur = formateurService.getFormateurById(id);

        updateFormateur.get().setNom(formateur.getNom());
        updateFormateur.get().setPrenom(formateur.getPrenom());
        updateFormateur.get().setEmail(formateur.getEmail());
        updateFormateur.get().setPhoto(formateur.getPhoto());


        formateurService.addFormateur(updateFormateur);

        return updateFormateur;
    }
}
