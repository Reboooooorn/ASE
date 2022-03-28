package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UC4ratePerfumeTest {

    @Mock
    private RatingRepository ratingRepository;
    @Mock
    private PerfumeRepository perfumeRepository;

    @InjectMocks
    private UC4ratePerfume uc4ratePerfume;

    private Country country;
    private Manufacturer manufacturer;
    private BaseNote baseNote;
    private HeartNote heartNote;
    private HeadNote headNote;
    private Perfume perfume;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "UKR", "Ukraine");
        manufacturer = new Manufacturer("Testhersteller",country);
        baseNote = new BaseNote("Basisnote","Basis");
        heartNote = new HeartNote("Herznote","Herz");
        headNote = new HeadNote("Kopfnote","Kopf");
        perfume = new Perfume(1L,"Test",1996,manufacturer,420,baseNote,heartNote,headNote,null);
    }

    @Test
    void createRating() {
        Rating rating = new Rating(perfume,"Max Mustermann",1,1,1,1,1);
        Optional<Perfume> optionalPerfume = Optional.of(perfume);

        doReturn(rating).when(this.ratingRepository).save(any(Rating.class));
        doReturn(true).when(this.perfumeRepository).existsById(1L);
        doReturn(optionalPerfume).when(this.perfumeRepository).findById(1L);

        Rating createdRating = uc4ratePerfume.createRating(rating);
        verify(this.ratingRepository, times(1)).save(any(Rating.class));
        assertEquals(createdRating, rating);
    }
}
