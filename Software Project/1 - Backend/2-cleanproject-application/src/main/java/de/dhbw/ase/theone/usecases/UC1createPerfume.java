package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeBuilder;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class UC1createPerfume {

    private PerfumeRepository perfumeRepository;
    private ManufacturerRepository manufacturerRepository;
    private NoteRepository noteRepository;
    private CollectionRepository collectionRepository;

    @Autowired
    public UC1createPerfume(PerfumeRepository perfumeRepository,ManufacturerRepository manufacturerRepository,NoteRepository noteRepository,CollectionRepository collectionRepository) {
        this.perfumeRepository = perfumeRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.noteRepository = noteRepository;
        this.collectionRepository = collectionRepository;
    }

    public Perfume createPerfume(Perfume perfume){
        Optional<Manufacturer> targetManufacturer = manufacturerRepository.findById(perfume.getManufacturer().getId());
        if(targetManufacturer.isPresent() && !perfumeRepository.existsByNameAndManufacturer(perfume.getName(), targetManufacturer.get())){
            Optional<Note> targetBaseNote = noteRepository.getNoteByID(perfume.getBaseNote().getId());
            Optional<Note> targetHeartNote = noteRepository.getNoteByID(perfume.getHeartNote().getId());
            Optional<Note> targetHeadNote =  noteRepository.getNoteByID(perfume.getHeadNote().getId());

            Optional<Collection> targetCollection;
            if(null != perfume.getCollection()){
                targetCollection = collectionRepository.findFirstByName(perfume.getCollection().getName());
            }else{
                targetCollection = Optional.empty();
            }

            if(targetManufacturer.isPresent() &&
                    targetBaseNote.isPresent() &&
                    targetHeartNote.isPresent() &&
                    targetHeadNote.isPresent()){
                PerfumeBuilder newPerfume = new PerfumeBuilder(
                        perfume.getName(),
                        perfume.getYearOfManufacture(),
                        targetManufacturer.get(),
                        perfume.getSizeInMilliliter()
                );
                newPerfume.baseNote((BaseNote) targetBaseNote.get());
                newPerfume.heartNote((HeartNote) targetHeartNote.get());
                newPerfume.headNote((HeadNote) targetHeadNote.get());
                if (targetCollection.isPresent()) {
                    newPerfume.collection(targetCollection.get());
                }
                return perfumeRepository.save(newPerfume.build());
            }

        }
        throw new ValidationException(String.format("Parfum %s vom Hersteller %s ist bereits vorhanden",perfume.getName(),perfume.getManufacturer().getName()));
    }

}
