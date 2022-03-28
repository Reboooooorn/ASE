package de.dhbw.ase.theone.perfume;

import de.dhbw.ase.theone.collection.CollectionToCollectionResourceMapper;
import de.dhbw.ase.theone.manufacturer.ManufacturerToManufacturerResourceMapper;
import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.NoteResource;
import de.dhbw.ase.theone.note.NoteToNoteResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PerfumeToPerfumeResourceMapper implements Function<Perfume,PerfumeResource> {

    ManufacturerToManufacturerResourceMapper manufacturerToManufacturerResourceMapper;
    NoteToNoteResourceMapper noteToNoteResourceMapper;

    @Autowired
    public PerfumeToPerfumeResourceMapper(ManufacturerToManufacturerResourceMapper manufacturerToManufacturerResourceMapper, NoteToNoteResourceMapper noteToNoteResourceMapper) {
        this.manufacturerToManufacturerResourceMapper = manufacturerToManufacturerResourceMapper;
        this.noteToNoteResourceMapper = noteToNoteResourceMapper;
    }

    @Override
    public PerfumeResource apply(Perfume perfume) {
        return map(perfume);
    }

    private PerfumeResource map(Perfume perfume) {
        return new PerfumeResource(
                perfume.getId(),
                perfume.getName(),
                perfume.getYearOfManufacture(),
                manufacturerToManufacturerResourceMapper.apply(perfume.getManufacturer()),
                perfume.getSizeInMilliliter(),
                noteToNoteResourceMapper.apply(perfume.getBaseNote()),
                noteToNoteResourceMapper.apply(perfume.getHeartNote()),
                noteToNoteResourceMapper.apply(perfume.getHeadNote()),
                perfume.getCollection() != null ? perfume.getCollection().getName() : null);
    }

}
