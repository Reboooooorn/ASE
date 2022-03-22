package de.dhbw.ase.theone.services.country;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryApplicationService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryApplicationService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
