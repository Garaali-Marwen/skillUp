package com.skillup.Projet.Services.ServicesImplementation;

import com.skillup.Projet.Entities.Abonnement;
import com.skillup.Projet.Repositories.AbonnementRepository;
import com.skillup.Projet.Services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementServiceImpl implements AbonnementService {

    @Autowired
    AbonnementRepository abonnementRepository;

    @Override
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Optional<Abonnement> getAbonnementById(Long id) {
        return abonnementRepository.findById(id);
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Optional<Abonnement> editAbonnement(Long id, Abonnement abonnement) {
        Optional<Abonnement> newAbonnement = getAbonnementById(id);

        newAbonnement.get().setCentreFormation(abonnement.getCentreFormation());
        newAbonnement.get().setDateDebut(abonnement.getDateDebut());
        newAbonnement.get().setDateFin(abonnement.getDateFin());
        newAbonnement.get().setType(abonnement.getType());
        newAbonnement.get().setTransaction(abonnement.getTransaction());

        abonnementRepository.save(abonnement);
        return newAbonnement;
    }

    @Override
    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }
}
