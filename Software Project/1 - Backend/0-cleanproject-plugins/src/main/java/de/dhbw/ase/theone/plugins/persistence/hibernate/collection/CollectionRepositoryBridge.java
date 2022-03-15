package de.dhbw.ase.theone.plugins.persistence.hibernate.collection;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CollectionRepositoryBridge implements CollectionRepository {

    private SpringDataCollectionRepository springDataCollectionRepository;

    @Autowired
    public CollectionRepositoryBridge(SpringDataCollectionRepository springDataCollectionRepository) {
        this.springDataCollectionRepository = springDataCollectionRepository;
    }

    @Override
    public Collection save(Collection collection) {
        return springDataCollectionRepository.save(collection);
    }

    @Override
    public boolean existsByName(String collectionName) {
        return springDataCollectionRepository.existsByName(collectionName);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataCollectionRepository.existsById(id);
    }

    @Override
    public List<Collection> findAllCollections() {
        return springDataCollectionRepository.findAll();
    }

    @Override
    public Optional<Collection> findById(long collectionID) {
        return springDataCollectionRepository.findById(collectionID);
    }
}
