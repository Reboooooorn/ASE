package de.dhbw.ase.theone.plugins.persistence.hibernate.country;

import de.dhbw.ase.theone.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCountryRepository extends JpaRepository<Country, Long> {

    Country save(Country country);


}
