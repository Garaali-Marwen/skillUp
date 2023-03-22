package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Entities.Manager;
import com.Projet.Projet.Enum.Role;
import com.Projet.Projet.Repositories.ManagerRepository;
import com.Projet.Projet.Services.CentreFormationService;
import com.Projet.Projet.Services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private ManagerRepository managerRepository;
    private CentreFormationService centreFormationService;
    @Override
    public Manager addManager(Manager manager) {
        manager.setRole(Role.MANAGER);
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public void deleteManager(Long managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    public Manager getManagerById(Long managerId) {
        return managerRepository.findById(managerId).orElseThrow(
                () -> new NoSuchElementException("Aucun manager avec ID: " + managerId));
    }

    @Override
    public Manager updateManager(Manager manager) {
        if (!managerRepository.existsById(manager.getId())){
            throw new NoSuchElementException("Aucun manager avec ID: " + manager.getId());
        }
        return managerRepository.save(manager);
    }

    @Override
    public Manager affectCenterToManager(Long centreId, Long managerId) {
        Manager manager = getManagerById(managerId);
        CentreFormation centreFormation = centreFormationService.getCentreFormationById(centreId);
        manager.getCentreFormation().add(centreFormation);
        updateManager(manager);
        centreFormation.setManager(manager);
        centreFormationService.updateCentreFormation(centreFormation);
        return manager;
    }
}
