package de.dhbw.ase.theone.country;

import de.dhbw.ase.theone.manufacturer.Manufacturer;
import lombok.Getter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abbreviation", nullable = false, length = 3, unique = true)
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Transient
    @OneToMany
    private List<Manufacturer> manufacturerList = new LinkedList<>();

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public Country() {
        //Intentionally Blank for Jackson
    }
}
