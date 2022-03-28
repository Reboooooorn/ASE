package de.dhbw.ase.theone.services.manufacturer;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.services.country.CountryApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManufacturerApplicationServiceTest {
    @Mock
    ManufacturerRepository manufacturerRepository;

    @InjectMocks
    ManufacturerApplicationService manufacturerApplicationService;

    private Manufacturer manufacturer;
    private Manufacturer secondManufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer(1L, "Manu1", new Country(1L, "UKR", "Ukraine"));
        secondManufacturer = new Manufacturer(2L, "Manu2", new Country(69L, "D", "Deutschland"));
    }

    @Test
    void getAllManufacturers() {
        List<Manufacturer> manufacturers = Arrays.asList(manufacturer, secondManufacturer);

        doReturn(Arrays.asList(manufacturer, secondManufacturer)).when(this.manufacturerRepository).findAllManufacturers();

        List<Manufacturer> readManufacturers = this.manufacturerApplicationService.getAllManufacturers();

        verify(this.manufacturerRepository, times(1)).findAllManufacturers();

        assertEquals(manufacturers, readManufacturers);
    }
}
