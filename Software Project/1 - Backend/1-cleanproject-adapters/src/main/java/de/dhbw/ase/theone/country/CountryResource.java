package de.dhbw.ase.theone.country;

import lombok.Getter;

@Getter
public class CountryResource {

    private String abbreviation;
    private String name;

    public CountryResource(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
}
