package com.emsi.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom,matricule;

    @ManyToMany(mappedBy = "etudiants")
    private Collection<Seance> seances;

    @Override
    public String toString() {
        return "Etudiant{" +
                " id=" + id +
                ", nom='" + nom + '\'' +
                ", matricule='" + matricule + '\'' +
                //", seances=" + seances +
                '}';
    }
    public void afficher() {
        System.out.println("Etudiant {" +" id=" + id +", nom='" + nom + '\'' +", matricule='" + matricule  + '}');
    }


}
