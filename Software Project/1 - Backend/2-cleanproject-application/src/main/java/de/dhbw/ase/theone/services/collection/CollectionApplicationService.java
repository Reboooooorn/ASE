package de.dhbw.ase.theone.services.collection;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionApplicationService {

    private CollectionRepository collectionRepository;

    @Autowired
    public CollectionApplicationService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAllCollections() {
        return collectionRepository.findAllCollections();
    }

}
