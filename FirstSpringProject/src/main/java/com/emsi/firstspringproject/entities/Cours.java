package com.emsi.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre,description;

    @OneToMany(mappedBy="cours" , fetch= FetchType.LAZY)
    private Collection<Seance>seances;

    @OneToOne
    private Professeur Professeur;
}
