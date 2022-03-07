package de.dhbw.ase.theone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            // TODO
        };
    }

}
