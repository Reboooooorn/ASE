package de.dhbw.ase.theone.perfume;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.manufacturer.ManufacturerResourceToManufacturerMapper;
import de.dhbw.ase.theone.manufacturer.ManufacturerToManufacturerResourceMapper;
import de.dhbw.ase.theone.note.NoteResourceToNoteMapper;
import de.dhbw.ase.theone.note.NoteToNoteResourceMapper;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PerfumeResourceToPerfumeMapper implements Function<PerfumeResource,Perfume> {

    ManufacturerResourceToManufacturerMapper manufacturerResourceToManufacturerMapper;
    NoteResourceToNoteMapper noteResourceToNoteMapper;


    @Autowired
    public PerfumeResourceToPerfumeMapper(ManufacturerResourceToManufacturerMapper manufacturerResourceToManufacturerMapper, NoteResourceToNoteMapper noteResourceToNoteMapper) {
        this.manufacturerResourceToManufacturerMapper = manufacturerResourceToManufacturerMapper;
        this.noteResourceToNoteMapper = noteResourceToNoteMapper;
    }

    @Override
    public Perfume apply(PerfumeResource perfumeResource) {
        return map(perfumeResource);
    }

    private Perfume map(PerfumeResource perfumeResource) {
        PerfumeBuilder perfumeBuilder =  new PerfumeBuilder(
                perfumeResource.getName(),
                perfumeResource.getYearOfManufacture(),
                manufacturerResourceToManufacturerMapper.apply(perfumeResource.getManufacturer()),
                perfumeResource.getSizeInMilliliter());
        perfumeBuilder.id(perfumeResource.getId());
        perfumeBuilder.baseNote((BaseNote) noteResourceToNoteMapper.apply(perfumeResource.getBasicNote()));
        perfumeBuilder.heartNote((HeartNote) noteResourceToNoteMapper.apply(perfumeResource.getHeartNote()));
        perfumeBuilder.headNote((HeadNote) noteResourceToNoteMapper.apply(perfumeResource.getHeadNote()));
        perfumeBuilder.collection(new Collection(perfumeResource.getCollectionName()));
        return perfumeBuilder.build();
    }

}
