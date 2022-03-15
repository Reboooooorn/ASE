package de.dhbw.ase.theone.plugins.persistence.hibernate.note;

import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositoryBridge implements NoteRepository {

    private SpringDataNoteRepository springDataNoteRepository;

    @Autowired
    public NoteRepositoryBridge(SpringDataNoteRepository springDataNoteRepository) {
        this.springDataNoteRepository = springDataNoteRepository;
    }

    @Override
    public BaseNote save(BaseNote baseNote) {
        return springDataNoteRepository.save(baseNote);
    }
    @Override
    public HeartNote save(HeartNote heartNote) {
        return springDataNoteRepository.save(heartNote);
    }
    @Override
    public HeadNote save(HeadNote headNote) {
        return springDataNoteRepository.save(headNote);
    }

    @Override
    public Optional<Note> getNoteByID(long id) {
        return springDataNoteRepository.findById(id);
    }

    @Override
    public List<BaseNote> findAllBaseNotes() {
        return springDataNoteRepository.getAllBaseNotes();
    }

    @Override
    public List<HeartNote> findAllHeartNotes() {
        return springDataNoteRepository.getAllHeartNotes();
    }

    @Override
    public List<HeadNote> findAllHeadNotes() {
        return springDataNoteRepository.getAllHeadNotes();
    }
}
