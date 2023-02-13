package com.skillup.Projet.Repositories;

import com.skillup.Projet.Entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRespository extends JpaRepository<Formateur, Long> {
}
