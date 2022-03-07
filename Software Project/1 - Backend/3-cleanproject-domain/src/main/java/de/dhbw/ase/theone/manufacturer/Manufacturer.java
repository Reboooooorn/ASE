package de.dhbw.ase.theone.manufacturer;

import de.dhbw.ase.theone.manufacturer.listener.ManufacturerListener;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "manufacturer")
@EntityListeners(ManufacturerListener.class)
public class Manufacturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
