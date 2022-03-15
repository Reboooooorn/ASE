package de.dhbw.ase.theone.plugins.persistence.hibernate.wishlist;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.wishlist.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataWishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByName(String wishlistName);
}
