package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Manager;
import com.Projet.Projet.Services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }
    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable("id") Long managerId) {
        return managerService.getManagerById(managerId);
    }
    @PostMapping("/add")
    public Manager addManager(@RequestBody Manager manager) {
        return managerService.addManager(manager);
    }
    @PutMapping("/update")
    public Manager updateManager(@RequestBody Manager manager) {
        return managerService.updateManager(manager);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable("id") Long managerId) {
        managerService.deleteManager(managerId);
    }
    @GetMapping("/{mid}/center/{cid}")
    public Manager affectCenterToManager(@PathVariable("cid") Long centerId, @PathVariable("mid") Long managerId) {
        return managerService.affectCenterToManager(centerId, managerId);
    }
}
