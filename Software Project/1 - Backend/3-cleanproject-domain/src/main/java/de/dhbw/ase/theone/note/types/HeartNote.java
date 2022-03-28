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
@DiscriminatorValue("Herznote")
@NoArgsConstructor
@EntityListeners(NoteListener.class)
public class HeartNote extends Note {

    @Transient
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "heartNote")
    List<Perfume> perfumeList = new LinkedList<>();

    public HeartNote(String name,String smell){
        super(name,smell);
    }

    public HeartNote(Long id, String name, String smell) {
        super(id, name, smell);
    }
}
