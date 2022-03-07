package de.dhbw.ase.theone.manufacturer;

import java.util.List;

public interface ManufacturerRepository {

    Manufacturer save(Manufacturer manufacturer);

    List<Manufacturer> findAllManufacturers();

}
