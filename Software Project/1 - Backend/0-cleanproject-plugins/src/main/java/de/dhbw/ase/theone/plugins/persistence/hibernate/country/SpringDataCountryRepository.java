package de.dhbw.ase.theone.plugins.persistence.hibernate.country;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCountryRepository extends JpaRepository<Manufacturer, Long> {

    Country save(Country country);


}
