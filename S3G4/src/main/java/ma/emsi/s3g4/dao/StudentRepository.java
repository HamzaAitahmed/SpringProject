package ma.emsi.s3g4.dao;

import ma.emsi.s3g4.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFullName(String name);
    List<Student> findByFullNameConataines(String name);
}
