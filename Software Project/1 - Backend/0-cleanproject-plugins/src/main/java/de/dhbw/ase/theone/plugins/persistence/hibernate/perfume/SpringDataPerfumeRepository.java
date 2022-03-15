package de.dhbw.ase.theone.plugins.persistence.hibernate.perfume;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.perfume.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPerfumeRepository extends JpaRepository<Perfume, Long> {
    boolean existsByNameAndManufacturer(String name, Manufacturer manufacturer);
}
