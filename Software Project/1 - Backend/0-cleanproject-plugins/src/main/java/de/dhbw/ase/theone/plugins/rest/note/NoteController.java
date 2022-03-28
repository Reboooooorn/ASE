package de.dhbw.ase.theone.plugins.rest.note;

import de.dhbw.ase.theone.note.NoteResource;
import de.dhbw.ase.theone.note.NoteToNoteResourceMapper;
import de.dhbw.ase.theone.services.note.NoteApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/note")
public class NoteController {

    private NoteApplicationService noteApplicationService;
    private NoteToNoteResourceMapper noteToNoteResourceMapper;

    @Autowired
    public NoteController(
            NoteApplicationService noteApplicationService,
            NoteToNoteResourceMapper noteToNoteResourceMapper) {
        this.noteApplicationService = noteApplicationService;
        this.noteToNoteResourceMapper = noteToNoteResourceMapper;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/base")
    public List<NoteResource> getBaseNotes() {
        return this.noteApplicationService.getAllBasicNotes().stream()
                .map(noteToNoteResourceMapper)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/heart")
    public List<NoteResource> getHeartNotes() {
        return this.noteApplicationService.getAllHeartNotes().stream()
                .map(noteToNoteResourceMapper)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/head")
    public List<NoteResource> getHeadNotes() {
        return this.noteApplicationService.getAllHeadNotes().stream()
                .map(noteToNoteResourceMapper)
                .collect(Collectors.toList());
    }

}
