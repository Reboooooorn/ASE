package de.dhbw.ase.theone.plugins.rest.collection;

import de.dhbw.ase.theone.collection.CollectionRessource;
import de.dhbw.ase.theone.collection.CollectionToCollectionResourceMapper;
import de.dhbw.ase.theone.services.collection.CollectionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/collection")
public class CollectionController {

    private CollectionApplicationService collectionApplicationService;
    private CollectionToCollectionResourceMapper collectionToCollectionResourceMapper;

    @Autowired
    public CollectionController(CollectionApplicationService collectionApplicationService, CollectionToCollectionResourceMapper collectionToCollectionResourceMapper) {
        this.collectionApplicationService = collectionApplicationService;
        this.collectionToCollectionResourceMapper = collectionToCollectionResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CollectionRessource> getAllCollections() {
        return this.collectionApplicationService.getAllCollections().stream()
                .map(collectionToCollectionResourceMapper)
                .collect(Collectors.toList());
    }

}
