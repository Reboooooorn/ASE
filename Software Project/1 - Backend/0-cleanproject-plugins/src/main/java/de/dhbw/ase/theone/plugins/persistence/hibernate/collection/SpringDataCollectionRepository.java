package de.dhbw.ase.theone.plugins.persistence.hibernate.collection;

import de.dhbw.ase.theone.collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCollectionRepository extends JpaRepository<Collection, Long> {
    boolean existsByName(String collectionName);
}
