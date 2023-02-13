package com.skillup.Projet.Controller;

import com.skillup.Projet.Entities.Formation;
import com.skillup.Projet.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formation")
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
