package de.dhbw.ase.theone.rating;

import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.rating.listener.RatingListener;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ratings")
@EntityListeners(RatingListener.class)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;

    @Column(name = "username")
    private String username;

    @Column(name = "Wertung_Duft")
    @Min(0)
    @Max(10)
    private int value_scent;

    @Column(name = "Wertung_Haltbarkeit")
    @Min(0)
    @Max(10)
    private int value_durability;

    @Column(name = "Wertung_Sillage")
    @Min(0)
    @Max(10)
    private int value_sillage;

    @Column(name = "Wertung_Flakon")
    @Min(0)
    @Max(10)
    private int value_vial;

    @Column(name = "Wertung_PreisLeistung")
    @Min(0)
    @Max(10)
    private int value_charge;

    public Rating(Perfume perfume, String username, int value_scent, int value_durability, int value_sillage, int value_vial, int value_charge) {
        this.perfume = perfume;
        this.username = username;
        this.value_scent = value_scent;
        this.value_durability = value_durability;
        this.value_sillage = value_sillage;
        this.value_vial = value_vial;
        this.value_charge = value_charge;
    }
}
