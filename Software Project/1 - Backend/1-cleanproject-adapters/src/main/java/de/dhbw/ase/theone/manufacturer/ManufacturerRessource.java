package de.dhbw.ase.theone.manufacturer;

import lombok.Getter;

@Getter
public class ManufacturerRessource {

    private String name;
    private String country;

    public ManufacturerRessource(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
