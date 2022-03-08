package de.dhbw.ase.theone.manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository {

    Manufacturer save(Manufacturer manufacturer);

    List<Manufacturer> findAllManufacturers();

    Optional<Manufacturer> findById(long id);

}
