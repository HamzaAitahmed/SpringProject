package com.emsi.firstspringproject;

import com.emsi.firstspringproject.dao.*;
import com.emsi.firstspringproject.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FirstSpringProjectApplication implements CommandLineRunner {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student(null, "abcd", "name", new Date(), true, new Date()));

        etudiantRepository.save(new Etudiant(null, "Mouhcine", "teste" ,null) );
        etudiantRepository.save(new Etudiant(null, "hamza", "xyw" ,null) );
        etudiantRepository.save(new Etudiant(null, "Imad", "iued" ,null) );
        etudiantRepository.save(new Etudiant(null, "X", "teste" , null ) );

        Etudiant et = etudiantRepository.findById(1).orElse(null);
        System.out.println("To String Function : "+et); // j'ai mis  seances Collection en commentaire
        et.afficher();

    }


}
