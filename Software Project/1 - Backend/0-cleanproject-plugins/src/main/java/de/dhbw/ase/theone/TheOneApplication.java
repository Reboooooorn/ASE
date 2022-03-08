package de.dhbw.ase.theone;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("de.dhbw.*")
@ComponentScan("de.dhbw.*")
@EnableJpaRepositories("de.dhbw.*")
public class TheOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryRepository countryRepository,ManufacturerRepository manufacturerRepository) {
        return (args) -> {
            Country ukraine = new Country("UKR","Ukraine");
            Country germany = new Country("GER","Deutschland");
            Country france = new Country("FRA","Frankreich");

            countryRepository.save(ukraine);
            countryRepository.save(germany);
            countryRepository.save(france);

            Manufacturer testManufacturer = new Manufacturer("Testhersteller",ukraine);
            manufacturerRepository.save(testManufacturer);
        };
    }

}
