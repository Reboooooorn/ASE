package de.dhbw.ase.theone.country;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryToCountryResourceMapper implements Function<Country, CountryResource> {

    @Override
    public CountryResource apply(Country country) {
        return map(country);
    }

    private CountryResource map(Country country) {
        return new CountryResource(country.getAbbreviation(), country.getName());
    }

}
