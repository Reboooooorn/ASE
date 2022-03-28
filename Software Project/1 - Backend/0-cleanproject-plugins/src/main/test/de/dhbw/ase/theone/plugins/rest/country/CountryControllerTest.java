package de.dhbw.ase.theone.plugins.rest.country;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.services.country.CountryApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = de.dhbw.ase.theone.TheOneApplication.class)
@AutoConfigureMockMvc
class CountryControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CountryController countryController;

    @MockBean
    CountryApplicationService countryApplicationService;

    private Country country;
    private Country secondCountry;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "UKR", "Ukraine");
        secondCountry = new Country(2L, "D", "Deutschland");
    }

    @Test
    void getCountries() throws Exception {
        List<Country> countries = Arrays.asList(country, secondCountry);
        doReturn(countries).when(this.countryController).getCountries();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/country")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        List<Country> readCountries = Arrays.asList(this.objectMapper.reader().forType(Country[].class).readValue(responseBody));

        assertEquals(countries.get(0).getAbbreviation(), readCountries.get(0).getAbbreviation());
        assertEquals(countries.get(0).getName(), readCountries.get(0).getName());

        assertEquals(countries.get(1).getAbbreviation(), readCountries.get(1).getAbbreviation());
        assertEquals(countries.get(1).getName(), readCountries.get(1).getName());


    }
}
