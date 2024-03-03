package com.emsi.firstspringproject.dao;

import com.emsi.firstspringproject.entities.Etudiant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
