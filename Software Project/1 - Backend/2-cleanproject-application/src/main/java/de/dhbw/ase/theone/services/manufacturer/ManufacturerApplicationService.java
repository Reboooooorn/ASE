package de.dhbw.ase.theone.services.manufacturer;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerApplicationService {

    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerApplicationService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAllManufacturers();
    }
}
