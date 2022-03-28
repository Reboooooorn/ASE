package de.dhbw.ase.theone.wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository {

    Wishlist save(Wishlist wishlist);

    boolean existsByName(String wishlistName);
    boolean existsById(Long id);

    List<Wishlist> findAllWishlists();

    Optional<Wishlist> findById(long wishlistID);
}
