package de.dhbw.ase.theone.country;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryResourceToCountryMapper implements Function<CountryResource, Country> {


    @Override
    public Country apply(CountryResource countryResource) {
        return map(countryResource);
    }

    private Country map(CountryResource countryResource) {
        return new Country(countryResource.getAbbreviation(), countryResource.getName());
    }

}
