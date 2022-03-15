package de.dhbw.ase.theone.plugins.persistence.hibernate.perfume;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.plugins.persistence.hibernate.manufacturer.SpringDataManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerfumeRepositoryBridge implements PerfumeRepository {

    private SpringDataPerfumeRepository springDataManufacturerRepository;

    @Autowired
    public PerfumeRepositoryBridge(SpringDataPerfumeRepository springDataManufacturerRepository) {
        this.springDataManufacturerRepository = springDataManufacturerRepository;
    }

    @Override
    public Perfume save(Perfume perfume) {
        return springDataManufacturerRepository.save(perfume);
    }

    @Override
    public boolean existsByNameAndManufacturer(String name, Manufacturer manufacturer) {
        return springDataManufacturerRepository.existsByNameAndManufacturer(name,manufacturer);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataManufacturerRepository.existsById(id);
    }

    @Override
    public List<Perfume> findAllPerfumes() {
        return springDataManufacturerRepository.findAll();
    }

    @Override
    public Optional<Perfume> findById(long perfumeID) {
        return springDataManufacturerRepository.findById(perfumeID);
    }
}
