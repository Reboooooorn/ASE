package de.dhbw.ase.theone.collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.dhbw.ase.theone.collection.listener.CollectionListener;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.perfume.Perfume;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "collections")
@EntityListeners(CollectionListener.class)
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @JsonIgnoreProperties
    @OneToMany()
    @JoinColumn(name = "collectionId")
    private Set<Perfume> perfumeList = new HashSet<>();

    public Collection(String name) {
        this.name = name;
    }

    public Collection(String name, Set<Perfume> perfumeList) {
        this.name = name;
        this.perfumeList = perfumeList;
    }

    public void addPerfume(Perfume perfume) {
        this.perfumeList.add(perfume);
    }
}
