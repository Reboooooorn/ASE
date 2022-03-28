package de.dhbw.ase.theone.plugins.persistence.hibernate.collection;

import de.dhbw.ase.theone.collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataCollectionRepository extends JpaRepository<Collection, Long> {
    boolean existsByName(String collectionName);
    Optional<Collection> findFirstByName(String name);
}
