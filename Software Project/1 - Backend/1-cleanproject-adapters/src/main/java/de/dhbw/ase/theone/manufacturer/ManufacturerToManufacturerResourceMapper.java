package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.country.CountryToCountryResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ManufacturerToManufacturerResourceMapper implements Function<Manufacturer, ManufacturerResource> {

    CountryToCountryResourceMapper countryToCountryResourceMapper;

    @Autowired
    public ManufacturerToManufacturerResourceMapper(CountryToCountryResourceMapper countryToCountryResourceMapper) {
        this.countryToCountryResourceMapper = countryToCountryResourceMapper;
    }

    @Override
    public ManufacturerResource apply(Manufacturer manufacturer) {
        return map(manufacturer);
    }

    private ManufacturerResource map(Manufacturer manufacturer) {
        return new ManufacturerResource(manufacturer.getId(),manufacturer.getName(), countryToCountryResourceMapper.apply(manufacturer.getCountry()));
    }

}
