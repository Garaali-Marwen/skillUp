package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Formation;
import com.Projet.Projet.Services.FormationService;
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
    @GetMapping("/{id}")
    public Formation getFormationById(@PathVariable("id") Long formationId){
        return formationService.getFormationById(formationId);
    }
    @PostMapping("/add")
    public Formation addFormation(@RequestBody Formation formation){
        return formationService.addFormation(formation);
    }
    @PutMapping("/update")
    public Formation updateFormation(@RequestBody Formation formation){
        return formationService.updateFormation(formation);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFormation(@PathVariable("id") Long formationId){
        formationService.deleteFormation(formationId);
    }

    @GetMapping("/seance/{sid}/formation/{fid}")
    public Formation addSeanceToFormation(@PathVariable("sid") Long seanceId, @PathVariable("fid") Long formationId){
        return formationService.addSeanceToFormation(seanceId,formationId);
    }

    @GetMapping("/{fid}/formateur/{formateurId}")
    public Formation addFormateurToFormation(@PathVariable("formateurId") Long formateurId, @PathVariable("fid") Long formationId){
        return formationService.addFormateurToFormation(formateurId,formationId);
    }
}
