package de.dhbw.ase.theone.note;

import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.function.Function;

@Component
public class NoteResourceToNoteMapper implements Function<NoteResource, Note> {

    @Override
    public Note apply(NoteResource noteResource) {
        return map(noteResource);
    }

    private Note map(NoteResource noteResource) {
        switch(noteResource.getType()){
            case "BaseNote" : return new BaseNote(noteResource.getId(),noteResource.getName(),noteResource.getSmell());
            case "HeartNote" : return new HeartNote(noteResource.getId(),noteResource.getName(),noteResource.getSmell());
            case "HeadNote" : return new HeadNote(noteResource.getId(),noteResource.getName(),noteResource.getSmell());
        }
        throw new ValidationException("Note Type not found!");
    }

}
