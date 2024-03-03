package com.emsi.firstspringproject.dao;

import com.emsi.firstspringproject.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
