package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UC2createCollectionTest {

    @Mock
    private CollectionRepository collectionRepository;

    @InjectMocks
    private UC2createCollection uc2createCollection;

    String collectionName = "Testcollection";

    @Test
    void createCollection() {
        Collection collection = new Collection(collectionName);
        doReturn(collection).when(this.collectionRepository).save(collection);
        Collection createdCollection = uc2createCollection.createCollection(collection);
        verify(this.collectionRepository, times(1)).save(any(Collection.class));
        assertEquals(collection, createdCollection);
    }
}
