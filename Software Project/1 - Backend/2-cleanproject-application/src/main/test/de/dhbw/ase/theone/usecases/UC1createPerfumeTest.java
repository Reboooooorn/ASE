package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
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

@ExtendWith(MockitoExtension.class)
class UC1createPerfumeTest {

    @Mock
    private CollectionRepository collectionRepository;
    @Mock
    private ManufacturerRepository manufacturerRepository;
    @Mock
    private NoteRepository noteRepository;
    @Mock
    private PerfumeRepository perfumeRepository;
    @InjectMocks
    private UC1createPerfume uc1createPerfume;

    private Country country;
    private Manufacturer manufacturer;
    private BaseNote baseNote;
    private HeartNote heartNote;
    private HeadNote headNote;
    private Perfume perfume;

    @BeforeEach
    void setUp() {
        country = new Country(1L, "UKR", "Ukraine");
        manufacturer = new Manufacturer(1L,"Testhersteller",country);
        baseNote = new BaseNote(1L,"Basisnote","Basis");
        heartNote = new HeartNote(2L,"Herznote","Herz");
        headNote = new HeadNote(3L,"Kopfnote","Kopf");
        perfume = new Perfume(1L,"Test",1996,manufacturer,420,baseNote,heartNote,headNote,null);
    }

    @Test
    void createPerfume() {
        Optional<Manufacturer> optionalManufacturer = Optional.of(manufacturer);
        Optional<Note> optionalBaseNote = Optional.of(baseNote);
        Optional<Note> optionalHeartNote = Optional.of(heartNote);
        Optional<Note> optionalHeadNote = Optional.of(headNote);

        doReturn(optionalManufacturer).when(this.manufacturerRepository).findById(1L);
        doReturn(false).when(this.perfumeRepository).existsByNameAndManufacturer("Test",manufacturer);
        doReturn(optionalBaseNote).when(this.noteRepository).getNoteByID(1L);
        doReturn(optionalHeartNote).when(this.noteRepository).getNoteByID(2L);
        doReturn(optionalHeadNote).when(this.noteRepository).getNoteByID(3L);
        doReturn(perfume).when(this.perfumeRepository).save(any(Perfume.class));

        Perfume createdPerfume = uc1createPerfume.createPerfume(perfume);

        verify(this.perfumeRepository, times(1)).save(any(Perfume.class));
        assertEquals(createdPerfume,perfume);

    }
}
