package de.dhbw.ase.theone.country;

import java.util.List;

public interface CountryRepository {

    Country save(Country country);

    List<Country> findAll();

}
