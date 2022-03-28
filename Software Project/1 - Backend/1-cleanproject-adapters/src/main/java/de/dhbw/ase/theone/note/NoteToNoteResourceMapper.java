package de.dhbw.ase.theone.note;

import de.dhbw.ase.theone.country.CountryToCountryResourceMapper;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NoteToNoteResourceMapper implements Function<Note, NoteResource> {

    @Override
    public NoteResource apply(Note note) {
        return map(note);
    }

    private NoteResource map(Note note) {
        return new NoteResource(note.getId(),note.getClass().getSimpleName(), note.getName(),note.getSmell());
    }

}
