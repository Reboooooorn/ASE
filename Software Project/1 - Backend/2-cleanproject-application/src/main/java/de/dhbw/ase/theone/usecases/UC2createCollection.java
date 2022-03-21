package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class UC2createCollection {

    private CollectionRepository collectionRepository;

    @Autowired
    public UC2createCollection(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection createCollection(Collection collection){
        if(!collectionRepository.existsByName(collection.getName())){
            return collectionRepository.save(collection);
        }
        throw new ValidationException(String.format("Kollektion %s ist bereits vorhanden",collection.getName()));
    }
}
