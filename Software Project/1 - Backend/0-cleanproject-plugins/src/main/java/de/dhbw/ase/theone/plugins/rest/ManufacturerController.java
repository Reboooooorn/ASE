package de.dhbw.ase.theone.plugins.rest;

import de.dhbw.ase.theone.manufacturer.ManufacturerApplicationService;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.manufacturer.ManufacturerRessource;
import de.dhbw.ase.theone.manufacturer.ManufacturerToManufacturerResourceMapper;
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
    public ManufacturerController(ManufacturerApplicationService manufacturerApplicationService, ManufacturerToManufacturerResourceMapper manufacturerToManufacturerResourceMapper) {
        this.manufacturerApplicationService = manufacturerApplicationService;
        this.manufacturerToManufacturerResourceMapper = manufacturerToManufacturerResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ManufacturerRessource> getBooks() {
        return this.manufacturerApplicationService.findAllManufacturers().stream()
                .map(manufacturerToManufacturerResourceMapper)
                .collect(Collectors.toList());
    }
}
