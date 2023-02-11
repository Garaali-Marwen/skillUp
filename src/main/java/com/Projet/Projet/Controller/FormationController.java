package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping("")
    public List<Formation> getAllFormations(){
        return formationService.getAllFormations();
    }

    @PostMapping("/add")
    public Formation addFormation(@RequestBody Formation formation){
        return formationService.addFormation(formation);
    }

}
