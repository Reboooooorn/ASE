package de.dhbw.ase.theone.plugins.rest.manufacturer;

import de.dhbw.ase.theone.manufacturer.ManufacturerResource;
import de.dhbw.ase.theone.manufacturer.ManufacturerToManufacturerResourceMapper;
import de.dhbw.ase.theone.services.manufacturer.ManufacturerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/manufacturer")
public class ManufacturerController {

    private ManufacturerApplicationService manufacturerApplicationService;
    private ManufacturerToManufacturerResourceMapper manufacturerToManufacturerResourceMapper;

    @Autowired
    public ManufacturerController(
            ManufacturerApplicationService manufacturerApplicationService,
            ManufacturerToManufacturerResourceMapper manufacturerToManufacturerResourceMapper) {
        this.manufacturerApplicationService = manufacturerApplicationService;
        this.manufacturerToManufacturerResourceMapper = manufacturerToManufacturerResourceMapper;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<ManufacturerResource> getManufacturer() {
        return this.manufacturerApplicationService.getAllManufacturers().stream()
                .map(manufacturerToManufacturerResourceMapper)
                .collect(Collectors.toList());
    }

}
