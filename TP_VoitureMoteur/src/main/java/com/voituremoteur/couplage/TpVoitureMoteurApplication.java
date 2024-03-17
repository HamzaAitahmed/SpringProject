package com.voituremoteur.couplage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpVoitureMoteurApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TpVoitureMoteurApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {}

}
