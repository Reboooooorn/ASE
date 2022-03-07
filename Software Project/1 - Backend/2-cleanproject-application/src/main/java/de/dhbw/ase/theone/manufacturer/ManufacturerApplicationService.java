package de.dhbw.ase.theone.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerApplicationService {

    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerApplicationService(ManufacturerRepository manufacturerRepository){
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> findAllManufacturers(){
        return this.manufacturerRepository.findAllManufacturers();
    }

}
