package de.dhbw.ase.theone.note;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "notes")
@DiscriminatorColumn(name = "note_type")
public abstract class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name",nullable = false)
    protected String name;

    @Column(name = "smell",nullable = false)
    protected String smell;

    public Note(String name, String smell) {
        this.name = name;
        this.smell = smell;
    }

    public Note(Long id, String name, String smell) {
        this.id = id;
        this.name = name;
        this.smell = smell;
    }
}
