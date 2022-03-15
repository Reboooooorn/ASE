package de.dhbw.ase.theone.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {
    private final Long ID = 1L;
    private final String ABBREVIATION = "UKR";
    private final String NEW_ABBREVIATION = "D";
    private final String NAME = "Ukraine";
    private final String NEW_NAME = "Deutschland";

    private Country country;

    @BeforeEach
    void setUp() {
        country = new Country(ID, ABBREVIATION, NAME);
    }

    @Test
    void getId() {
        assertEquals(ID, country.getId());
    }

    @Test
    void getAbbreviation() {
        assertEquals(ABBREVIATION, country.getAbbreviation());
    }

    @Test
    void setAbbreviation() {
        country.setAbbreviation(NEW_ABBREVIATION);
        assertEquals(NEW_ABBREVIATION, country.getAbbreviation());
    }

    @Test
    void getName() {
        assertEquals(NAME, country.getName());
    }

    @Test
    void setName() {
        country.setName(NEW_NAME);
        assertEquals(NEW_NAME, country.getName());
    }
}