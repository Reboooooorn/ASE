package de.dhbw.ase.theone.perfume;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.note.types.BaseNote;

import java.util.List;
import java.util.Optional;

public interface PerfumeRepository{

    Perfume save(Perfume perfume);

    boolean existsByNameAndManufacturer(String name, Manufacturer manufacturer);
    boolean existsById(Long id);

    List<Perfume> findAllPerfumes();

    Optional<Perfume> findById(long perfumeID);
}
