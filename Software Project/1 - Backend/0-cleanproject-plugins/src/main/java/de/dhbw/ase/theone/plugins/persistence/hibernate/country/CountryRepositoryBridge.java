package de.dhbw.ase.theone.plugins.persistence.hibernate.country;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.plugins.persistence.hibernate.manufacturer.SpringDataManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryBridge implements CountryRepository {

    private SpringDataCountryRepository springDataManufacturerRepository;

    @Autowired
    public CountryRepositoryBridge(SpringDataCountryRepository springDataManufacturerRepository) {
        this.springDataManufacturerRepository = springDataManufacturerRepository;
    }

    @Override
    public Country save(Country country) {
        return springDataManufacturerRepository.save(country);
    }
}
