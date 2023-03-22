package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Abonnement;
import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Entities.Offre;
import com.Projet.Projet.Repositories.CentreFormationRepository;
import com.Projet.Projet.Services.AbonnementService;
import com.Projet.Projet.Services.CentreFormationService;
import com.Projet.Projet.Services.OffreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CentreFormationImpl implements CentreFormationService {
    private  CentreFormationRepository centreFormationRepository;

    private AbonnementService abonnementService;

    private OffreService offreService;

    @Override
    public CentreFormation addCentre(CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);

    }
    @Override
    public List<CentreFormation> getAllCentreFormation() {
        return centreFormationRepository.findAll();
    }

    @Override
    public String deleteCentreFormation(final Long id) {
        CentreFormation centreFormation=centreFormationRepository.findById(id).orElse(null);
        if(centreFormation!=null){
            centreFormationRepository.delete(centreFormation);
            return "centre supprimé avec succé";
        }else
            return "centre n'existe pas";


    }

    @Override
    public CentreFormation getCentreFormationById(Long id) {
        return centreFormationRepository.findById(id).orElseThrow(()-> new NoSuchElementException(
                "NO Centre PRESENT WITH ID = " + id));
    }

    @Override
    public CentreFormation updateCentreFormation(Long cid, CentreFormation centreFormation){
        CentreFormation centreFormationDB = getCentreFormationById(cid);

        centreFormationDB.setNom(centreFormation.getNom());
        centreFormationDB.setAdresse(centreFormationDB.getAdresse());
        centreFormationDB.setRib(centreFormation.getRib());
        centreFormationDB.setTel(centreFormation.getTel());
        centreFormationDB.setEmail(centreFormation.getEmail());

        centreFormationRepository.save(centreFormationDB);

        return centreFormationDB;
    }

    @Override
    public CentreFormation addOffreToCentreFormation(Long cid, Long oid){
        CentreFormation centreFormation = getCentreFormationById(cid);
        Offre offre = offreService.getOfferById(oid);

        centreFormation.getOffres().add(offre);
        updateCentreFormation(cid,centreFormation);

        offre.setCentreFormation(centreFormation);
        return centreFormation;
    }

    @Override
    public CentreFormation addAbonnementToCentreFormation(Long aid, Long cid){
        CentreFormation centreFormation = getCentreFormationById(cid);
        Abonnement abonnement = abonnementService.getAbonnementById(aid);

        centreFormation.getAbonnements().add(abonnement);
        updateCentreFormation(cid,centreFormation);

        abonnement.setCentreFormation(centreFormation);

        return centreFormation;

    }


}
