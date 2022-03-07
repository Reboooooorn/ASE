package de.dhbw.ase.theone.plugins.persistence.hibernate.manufacturer;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
