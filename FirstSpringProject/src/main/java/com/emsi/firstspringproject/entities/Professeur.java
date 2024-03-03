package com.emsi.firstspringproject.entities;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    @Temporal(TemporalType.DATE)
    private Date d_affectation;

    @OneToOne
    private Cours Cours;
}
