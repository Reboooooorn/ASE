package de.dhbw.ase.theone.wishlist;

import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.wishlist.listener.WishlistListener;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "wishlist")
@EntityListeners(WishlistListener.class)
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "perfume_wishlist",
            joinColumns = @JoinColumn(name = "perfume_id"),
            inverseJoinColumns = @JoinColumn(name = "whishlist_id"))
    private Set<Perfume> includedPerfumes;

    public Wishlist() {
        this.includedPerfumes = new HashSet<>();
    }

    public Wishlist(String name) {
        this();
        this.name = name;
    }

    public Wishlist(String name, Set<Perfume> includedPerfumes) {
        this.name = name;
        this.includedPerfumes = includedPerfumes;
    }

    public void addPerfume(Perfume perfume) {
        this.includedPerfumes.add(perfume);
    }
}
