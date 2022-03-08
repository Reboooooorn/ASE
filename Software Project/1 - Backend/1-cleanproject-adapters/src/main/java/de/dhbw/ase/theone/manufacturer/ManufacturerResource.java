package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.country.CountryResource;
import lombok.Getter;

@Getter
public class ManufacturerResource {

    private String name;
    private CountryResource country;

    public ManufacturerResource(String name, CountryResource countryRessource) {
        this.name = name;
        this.country = countryRessource;
    }
}
