package de.dhbw.ase.theone.plugins.rest.country;

import de.dhbw.ase.theone.country.CountryResource;
import de.dhbw.ase.theone.country.CountryToCountryResourceMapper;
import de.dhbw.ase.theone.services.country.CountryApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/country")
public class CountryController {

    private CountryApplicationService countryApplicationService;
    private CountryToCountryResourceMapper countryToCountryResourceMapper;

    @Autowired
    public CountryController(CountryApplicationService countryApplicationService, CountryToCountryResourceMapper countryToCountryResourceMapper) {
        this.countryApplicationService = countryApplicationService;
        this.countryToCountryResourceMapper = countryToCountryResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CountryResource> getCountries() {
        return this.countryApplicationService.getAllCountries().stream()
                .map(countryToCountryResourceMapper)
                .collect(Collectors.toList());
    }

}
