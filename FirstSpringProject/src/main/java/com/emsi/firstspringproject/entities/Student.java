package com.emsi.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "EMSI_Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "REGISTRATION_N", unique = true)
    private String registraionNumber;

    @Column (name = "NAME", length=30 , nullable = false)
    private String fullname;

    @Temporal (TemporalType.DATE)
    private Date birth;

    private boolean stillActive;

    @Temporal (TemporalType.TIMESTAMP) @CreationTimestamp
    private Date lastConnection;
}
