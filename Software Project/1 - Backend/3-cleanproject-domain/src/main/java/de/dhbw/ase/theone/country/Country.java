package de.dhbw.ase.theone.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abbreviation", length = 3, unique = true, nullable = false)
    private String abbreviation;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "originCountryId")
    @JsonIgnore
    private List<Manufacturer> manufacturerList = new LinkedList<>();

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

}
