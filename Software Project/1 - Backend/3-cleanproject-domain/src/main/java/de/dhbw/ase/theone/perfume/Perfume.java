package de.dhbw.ase.theone.perfume;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.listener.PerfumeListener;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.wishlist.Wishlist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "perfume")
@EntityListeners(PerfumeListener.class)
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Herstellungsjahr", nullable = false)
    private long yearOfManufacture;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Manufacturer manufacturer;

    @Column(name = "sizeInMilliliter", nullable = false)
    private int sizeInMilliliter;

    @JoinColumn(name = "baseNote_id")
    @ManyToOne
    private BaseNote baseNote;

    @JoinColumn(name = "heartNode_id")
    @ManyToOne
    private HeartNote heartNote;

    @JoinColumn(name = "headNote_id")
    @ManyToOne
    private HeadNote headNote;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "collectionId")
    private Collection collection;

    @ManyToMany(mappedBy = "includedPerfumes")
    private Set<Wishlist> wishedLists;

    @OneToMany
    @JoinColumn(name = "perfume_id")
    private Set<Rating> ratings;

    public Perfume() {
        this.wishedLists = new HashSet<>();
        this.ratings = new HashSet<>();
        this.collection = null; // <- Verschönern
    }

    public Perfume(String name, long yearOfManufacture, Manufacturer manufacturer, int sizeInMilliliter, BaseNote baseNote, HeartNote heartNote, HeadNote headNote) {
        this();
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.sizeInMilliliter = sizeInMilliliter;
        this.baseNote = baseNote;
        this.heartNote = heartNote;
        this.headNote = headNote;
    }

    public Perfume(Long id, String name, long yearOfManufacture, Manufacturer manufacturer, int sizeInMilliliter, BaseNote baseNote, HeartNote heartNote, HeadNote headNote, Collection collection) {
        this(name, yearOfManufacture, manufacturer, sizeInMilliliter, baseNote, heartNote, headNote);
        this.id = id;
        this.collection = collection;
    }

    public Perfume(PerfumeBuilder perfumeBuilder) {
        this(
                perfumeBuilder.getId(),
                perfumeBuilder.getName(),
                perfumeBuilder.getYearOfManufacture(),
                perfumeBuilder.getManufacturer(),
                perfumeBuilder.getSizeInMilliliter(),
                perfumeBuilder.getBaseNote(),
                perfumeBuilder.getHeartNote(),
                perfumeBuilder.getHeadNote(),
                perfumeBuilder.getCollection()
        );
    }
}
