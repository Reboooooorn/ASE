package de.dhbw.ase.theone.collection;

import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CollectionToCollectionResourceMapper implements Function<Collection, CollectionRessource> {

    private PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper;

    @Autowired
    public CollectionToCollectionResourceMapper(PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper) {
        this.perfumeToPerfumeResourceMapper = perfumeToPerfumeResourceMapper;
    }

    @Override
    public CollectionRessource apply(Collection collection) {
        return map(collection);
    }

    private CollectionRessource map(Collection collection) {
        if (null != collection.getId()) {
            return new CollectionRessource(collection.getId(), collection.getName(), collection.getPerfumeList().stream().map(perfumeToPerfumeResourceMapper).collect(Collectors.toList()));
        } else {
            return new CollectionRessource(collection.getName(), collection.getPerfumeList().stream().map(perfumeToPerfumeResourceMapper).collect(Collectors.toList()));
        }
    }
}
