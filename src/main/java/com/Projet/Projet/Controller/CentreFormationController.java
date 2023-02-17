package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Services.CentreFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CentreFormation getCentreFormationById(@PathVariable("id") Long id){
        return centreFormationService.getCentreFormationById(id);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteCentreFormation(@PathVariable("id") Long id) {
        centreFormationService.deleteCentreFormation(id) ;
    }
    @PostMapping("/add")
    public CentreFormation addCentreFormation(@RequestBody CentreFormation centreFormation){
        return centreFormationService.addCentre(centreFormation);
    }

    @GetMapping("/{cid}/offre/{oid}")
    public CentreFormation addOffreToCentreFormation (@PathVariable Long cid, @PathVariable Long oid){
        return centreFormationService.addOffreToCentreFormation(cid,oid);
    }

    @GetMapping("/{cid}/abonnement/{aid}")
    public CentreFormation addAbonnementToCentreFormation(@PathVariable Long cid, @PathVariable Long aid){
        return centreFormationService.addAbonnementToCentreFormation(aid,cid);
    }
}
