package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Categorie;
import com.Projet.Projet.Services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable("id") Long categorieId) {
        return categorieService.getCategorieById(categorieId);
    }

    @PostMapping("/add")
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }

    @PutMapping("/update")
    public Categorie updateCategorie(@RequestBody Categorie categorie) {
        return categorieService.updateCategorie(categorie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable("id") Long categorieId) {
        categorieService.deleteCategorie(categorieId);
    }

    @GetMapping("/formation/{fid}/categorie/{cid}")
    public Categorie addFormationToCategorie(@PathVariable("fid") Long formationId, @PathVariable("cid") Long categorieId) {
        return categorieService.addFormationToCategorie(formationId, categorieId);
    }

    @GetMapping("/nom/{nom}")
    public Categorie getCategorieByName(@PathVariable("nom") String nom) {
        return categorieService.getCategorieByNom(nom);
    }

    @GetMapping("/formation/{id}")
    public Categorie getCategorieByFormations_Id(@PathVariable("id") Long id) {
        return categorieService.getCategorieByFormations_Id(id);
    }
}
