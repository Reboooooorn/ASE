package de.dhbw.ase.theone.country;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
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

    //Intentionally left Blank, because no useCases need this!

}
