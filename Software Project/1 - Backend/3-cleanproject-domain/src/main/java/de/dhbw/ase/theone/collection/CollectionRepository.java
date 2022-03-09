package de.dhbw.ase.theone.collection;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {

    Collection save(Collection collection);

    boolean existsByName(String collectionName);

    boolean existsById(Long id);

    List<Collection> findAllCollections();

    Optional<Collection> findById(long collectionID);
}
