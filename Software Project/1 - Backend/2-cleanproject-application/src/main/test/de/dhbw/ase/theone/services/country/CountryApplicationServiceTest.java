package de.dhbw.ase.theone.services.country;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryApplicationServiceTest {

    @Mock
    CountryRepository countryRepository;

    @InjectMocks
    CountryApplicationService countryApplicationService;

    private Country country;
    private Country secondCountry;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "UKR", "Ukraine");
        secondCountry = new Country(69L, "D", "Deutschland");
    }

    @Test
    void getAllCountries() {

        List<Country> countries = Arrays.asList(country, secondCountry);

        doReturn(Arrays.asList(country, secondCountry)).when(this.countryRepository).findAll();

        List<Country> readCountries = this.countryApplicationService.getAllCountries();

        verify(this.countryRepository, times(1)).findAll();

        assertEquals(countries, readCountries);
    }
}