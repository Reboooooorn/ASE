package de.dhbw.ase.theone.note.types;

import de.dhbw.ase.theone.note.Note;
import de.dhbw.ase.theone.note.listener.NoteListener;
import de.dhbw.ase.theone.perfume.Perfume;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Basisnote")
@NoArgsConstructor
@EntityListeners(NoteListener.class)
public class BaseNote extends Note {

    @Transient
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "baseNote")
    List<Perfume> perfumeList = new LinkedList<>();

    public BaseNote(String name, String smell){
        super(name,smell);
    }

    public BaseNote(Long id, String name, String smell) {
        super(id, name, smell);
    }
}
