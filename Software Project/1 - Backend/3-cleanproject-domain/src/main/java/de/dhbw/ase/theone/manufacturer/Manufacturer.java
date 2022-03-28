package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.listener.ManufacturerListener;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "manufacturer")
@EntityListeners(ManufacturerListener.class)
public class Manufacturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "originCountryId")
    private Country country;

    public Manufacturer(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Manufacturer(Long id, String name, Country country) {
        this(name,country);
        this.id = id;
    }
}
