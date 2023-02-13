package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Services.CentreFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/CentreFormation")
public class CentreFormationController {
    @Autowired
    private CentreFormationService centreFormationService;

    @GetMapping("")
    public List<CentreFormation> getAllCentreFormation(){
        return centreFormationService.getAllCentreFormation();
    }
    @GetMapping("/{id}")
    public CentreFormation getCentreFormationById(@PathVariable("id") Long id) throws Exception{
        CentreFormation c= centreFormationService.getCentreFormationById(id);
        if(c==null) {
            throw new Exception("Page not found for id : " + id);
        }
        return centreFormationService.getCentreFormationById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCentreFormation(@PathVariable("id") Long id) {
        return centreFormationService.deleteCentreFormation(id) ;
    }


    @PostMapping("/add")
    public String addCentreFormation(@RequestBody CentreFormation centreFormation){
        return centreFormationService.addCentre(centreFormation);
    }
    @PutMapping("/update")
    public CentreFormation updateCentreFormation(@RequestBody CentreFormation centreFormation){
        return centreFormationService.updateCentreFormation(centreFormation);
    }
}
