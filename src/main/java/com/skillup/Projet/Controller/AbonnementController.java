package com.skillup.Projet.Controller;

import com.skillup.Projet.Entities.Abonnement;
import com.skillup.Projet.Services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abonnement")
public class AbonnementController {

    @Autowired
    AbonnementService abonnementService;

    @GetMapping("")
    List<Abonnement> getAllAbonnements(){
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/{id}")
    Optional<Abonnement> getAbonnementById(@PathVariable Long id){
        return abonnementService.getAbonnementById(id);
    }

    @PostMapping("/add")
    Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return abonnementService.addAbonnement(abonnement);
    }

    @PutMapping("/edit/{id}")
    Optional<Abonnement> editAbonnement(@PathVariable Long id, @RequestBody Abonnement abonnement){
        return abonnementService.editAbonnement(id,abonnement);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAbonnement(@PathVariable Long id){
        abonnementService.deleteAbonnement(id);
    }
}
