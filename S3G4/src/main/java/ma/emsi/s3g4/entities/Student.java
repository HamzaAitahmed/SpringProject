package ma.emsi.s3g4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Students")
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

