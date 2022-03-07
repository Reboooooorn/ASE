package de.dhbw.ase.theone.plugins.persistence.hibernate.manufacturer;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturerRepositoryBridge implements ManufacturerRepository {

    private SpringDataManufacturerRepository springDataManufacturerRepository;

    @Autowired
    public ManufacturerRepositoryBridge(SpringDataManufacturerRepository springDataManufacturerRepository) {
        this.springDataManufacturerRepository = springDataManufacturerRepository;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return springDataManufacturerRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> findAllManufacturers() {
        return springDataManufacturerRepository.findAll();
    }
}
