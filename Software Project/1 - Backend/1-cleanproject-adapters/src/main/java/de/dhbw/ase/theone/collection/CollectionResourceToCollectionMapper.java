package de.dhbw.ase.theone.collection;

import de.dhbw.ase.theone.perfume.PerfumeResourceToPerfumeMapper;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CollectionResourceToCollectionMapper implements Function<CollectionRessource,Collection > {

    PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper;

    @Autowired
    public CollectionResourceToCollectionMapper(PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper) {
        this.perfumeResourceToPerfumeMapper = perfumeResourceToPerfumeMapper;
    }

    @Override
    public Collection apply(CollectionRessource collectionRessource) {
        return map(collectionRessource);
    }

    private Collection map(CollectionRessource collectionRessource) {
        return new Collection(collectionRessource.getName(),collectionRessource.perfumeResourceList.stream().map(perfumeResourceToPerfumeMapper).collect(Collectors.toSet()));
    }

}
