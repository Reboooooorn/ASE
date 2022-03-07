package de.dhbw.ase.theone.manufacturer;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ManufacturerToManufacturerResourceMapper implements Function<Manufacturer,ManufacturerRessource> {

    @Override
    public ManufacturerRessource apply(Manufacturer manufacturer) {
        return map(manufacturer);
    }

    private ManufacturerRessource map(Manufacturer manufacturer) {
        return new ManufacturerRessource(manufacturer.getName(), manufacturer.getCountry());
    }

}
