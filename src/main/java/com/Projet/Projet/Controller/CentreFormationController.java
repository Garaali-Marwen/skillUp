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
    public CentreFormation addCentreFormation(@RequestBody CentreFormation centreFormation){
        return centreFormationService.addCentre(centreFormation);
    }

    @GetMapping("/{cid}/offre/{oid}")
    public CentreFormation addOffreToCentreFormation (@PathVariable Long cid, @PathVariable Long oid){
        return centreFormationService.addOffreToCentreFormation(cid,oid);
    }

    @GetMapping("/{cid}/abonnement/{aid}")
    public CentreFormation addAbonnementToCentreFormation(@PathVariable Long cid, @PathVariable Long aid) {
        return centreFormationService.addAbonnementToCentreFormation(aid, cid);

    }
    @PutMapping("/update/{cid}")
    public CentreFormation updateCentreFormation(@PathVariable Long cid, @RequestBody CentreFormation centre ){
        return centreFormationService.updateCentreFormation(cid, centre);
    }
    @GetMapping("/{cid}/categorie/{caid}")
    public CentreFormation addCategorieToCentreFormation(@PathVariable Long cid, @PathVariable Long caid) {
        return centreFormationService.addCategorieToCentreFormation(caid, cid);
    }
    @GetMapping("/{cid}/formation/{fid}")
    public CentreFormation addFormationToCentreFormation(@PathVariable Long cid, @PathVariable Long fid) {
        return centreFormationService.addFormationToCentreFormation(fid, cid);
    }
    @GetMapping("/manager/{id}")
    public List<CentreFormation> getCentersByManagerId(@PathVariable("id") Long managerId){
        return centreFormationService.getAllByManagerId(managerId);
    }

}
