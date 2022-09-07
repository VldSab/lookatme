package ru.pet.lookatme.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            PersonModel cris = new PersonModel(
                    "127.0.0.1",
                    54.0,
                    54.0,
                    "Moskva",
                    "Russia"
            );

            repository.saveAll(
                    List.of(cris)
            );
        };
    }
}
