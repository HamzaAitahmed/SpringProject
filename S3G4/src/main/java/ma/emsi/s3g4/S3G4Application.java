package ma.emsi.s3g4;

import ma.emsi.s3g4.dao.*;
import ma.emsi.s3g4.entities.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class S3G4Application implements CommandLineRunner {
    @Autowired StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(S3G4Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*

        studentRepository.save(new Student(null, "abcd", "name", new Date(), true, new Date()));
        studentRepository.save(new Student(null, "adz", "name", new Date(), true, new Date()));
        studentRepository.save(new Student(null, "feazf", "name", new Date(), true, new Date()));

        studentRepository.findAll().forEach(System.out::println);

        */
        int page=0;
        int size=2;

        Page<Student> PStudent = studentRepository.findAll(PageRequest.of(page,size));
        PStudent.getContent().forEach(System.out::println);
        System.out.println("\n###############################\n");
        List<Student> s = studentRepository.findByFullName("hamza4");

        s.forEach(System.out::println);

    }
}
