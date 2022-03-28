package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.country.CountryResourceToCountryMapper;
import de.dhbw.ase.theone.country.CountryToCountryResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ManufacturerResourceToManufacturerMapper implements Function<ManufacturerResource, Manufacturer> {

    CountryResourceToCountryMapper countryResourceToCountryMapper;

    @Autowired
    public ManufacturerResourceToManufacturerMapper(CountryResourceToCountryMapper countryResourceToCountryMapper) {
        this.countryResourceToCountryMapper = countryResourceToCountryMapper;
    }

    @Override
    public Manufacturer apply(ManufacturerResource manufacturerResource) {
        return map(manufacturerResource);
    }

    private Manufacturer map(ManufacturerResource manufacturerResource) {
        return new Manufacturer(manufacturerResource.getId(),manufacturerResource.getName(), countryResourceToCountryMapper.apply(manufacturerResource.getCountry()));
    }

}
