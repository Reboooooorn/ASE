package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {
    private final Long ID = 1L;
    private final String NAME = "Testhersteller";
    private final Country COUNTRY = new Country(1L, "UKR", "Ukraine");

    private Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer(ID, NAME, COUNTRY);
    }

    @Test
    void getId() {
        assertEquals(ID, manufacturer.getId());
    }

    @Test
    void getName() {
        assertEquals(NAME, manufacturer.getName());
    }

    @Test
    void getCountry() {
        assertEquals(COUNTRY, manufacturer.getCountry());
    }
}
