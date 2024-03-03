package com.emsi.firstspringproject.entities;

import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date h_debut;

    @Temporal(TemporalType.TIME)
    private Date h_fin;

    @ManyToMany
    private Collection<Etudiant> etudiants;

    @ManyToOne
    private Cours cours;





}