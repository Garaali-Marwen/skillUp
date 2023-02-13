package com.skillup.Projet.Controller;

import com.skillup.Projet.Entities.Formateur;
import com.skillup.Projet.Services.FormateurService;
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

    @GetMapping("/{id}")
    public Optional<Formateur> getFormateuById(@PathVariable Long id){
        return formateurService.getFormateurById(id);
    }

    @PostMapping("/add")
    public Formateur addFormateur(@RequestBody Formateur formateur){
        return formateurService.addFormateur(formateur);
    }

    @PutMapping("/edit/{id}")
    public Optional<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        return formateurService.updateFormateur(id,formateur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFormateur(@PathVariable Long id){
        formateurService.deleteFormateur(id);
    }
}
