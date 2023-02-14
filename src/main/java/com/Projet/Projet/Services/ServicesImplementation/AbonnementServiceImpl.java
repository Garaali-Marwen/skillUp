package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.Abonnement;
import com.Projet.Projet.Repositories.AbonnementRepository;
import com.Projet.Projet.Services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
    public Abonnement getAbonnementById(Long id) {
        return abonnementRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("pas d'abonnement avec cet id"));
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement editAbonnement(Long id, Abonnement abonnement) {
        Abonnement newAbonnement = getAbonnementById(id);

        newAbonnement.setCentreFormation(abonnement.getCentreFormation());
        newAbonnement.setDateDebut(abonnement.getDateDebut());
        newAbonnement.setDateFin(abonnement.getDateFin());
        newAbonnement.setType(abonnement.getType());
        newAbonnement.setTransaction(abonnement.getTransaction());

        abonnementRepository.save(abonnement);
        return newAbonnement;
    }

    @Override
    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }
}
