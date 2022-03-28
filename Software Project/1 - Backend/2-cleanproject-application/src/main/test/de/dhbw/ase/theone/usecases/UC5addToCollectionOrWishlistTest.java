package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UC5addToCollectionOrWishlistTest {

    @Mock
    private CollectionRepository collectionRepository;
    @Mock
    private WishlistRepository wishlistRepository;
    @Mock
    private PerfumeRepository perfumeRepository;
    @InjectMocks
    private UC5addToCollectionOrWishlist uc5addToCollectionOrWishlist;

    private Country country;
    private Manufacturer manufacturer;
    private BaseNote baseNote;
    private HeartNote heartNote;
    private HeadNote headNote;
    private Perfume perfume;
    private Collection collection;
    private Wishlist wishlist;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "UKR", "Ukraine");
        manufacturer = new Manufacturer("Testhersteller",country);
        baseNote = new BaseNote("Basisnote","Basis");
        heartNote = new HeartNote("Herznote","Herz");
        headNote = new HeadNote("Kopfnote","Kopf");
        perfume = new Perfume(1L,"Test",1996,manufacturer,420,baseNote,heartNote,headNote,null);
        collection = new Collection(1L,"Test");
        wishlist = new Wishlist(1L,"Test");
    }

    @Test
    void addPerfumeToCollection() {
        Optional<Collection> optionalCollection = Optional.of(collection);
        Optional<Perfume> optionalPerfume = Optional.of(perfume);

        doReturn(true).when(this.perfumeRepository).existsById(1L);
        doReturn(true).when(this.collectionRepository).existsById(1L);
        doReturn(optionalCollection).when(this.collectionRepository).findById(1L);
        doReturn(optionalPerfume).when(this.perfumeRepository).findById(1L);
        doReturn(perfume).when(this.perfumeRepository).save(any(Perfume.class));

        Perfume perfume = uc5addToCollectionOrWishlist.addPerfumeToCollection(1L,1L);
        verify(this.perfumeRepository, times(1)).save(any(Perfume.class));
        assertEquals(collection,perfume.getCollection());
    }

    @Test
    void addPerfumeToWishlist() {
        Optional<Wishlist> optionalWishlist = Optional.of(wishlist);
        Optional<Perfume> optionalPerfume = Optional.of(perfume);

        doReturn(true).when(this.perfumeRepository).existsById(1L);
        doReturn(true).when(this.wishlistRepository).existsById(1L);
        doReturn(optionalWishlist).when(this.wishlistRepository).findById(1L);
        doReturn(optionalPerfume).when(this.perfumeRepository).findById(1L);
        doReturn(wishlist).when(this.wishlistRepository).save(any(Wishlist.class));

        Wishlist wishlistGet = uc5addToCollectionOrWishlist.addPerfumeToWishlist(1L,1L);
        verify(this.wishlistRepository, times(1)).save(any(Wishlist.class));
        assertEquals(wishlist,wishlistGet);
    }
}
