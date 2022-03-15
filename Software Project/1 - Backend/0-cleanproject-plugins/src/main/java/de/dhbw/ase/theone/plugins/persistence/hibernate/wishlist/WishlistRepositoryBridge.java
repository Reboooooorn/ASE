package de.dhbw.ase.theone.plugins.persistence.hibernate.wishlist;

import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WishlistRepositoryBridge implements WishlistRepository {

    private SpringDataWishlistRepository springDataWishlistRepository;

    @Autowired
    public WishlistRepositoryBridge(SpringDataWishlistRepository springDataWishlistRepository) {
        this.springDataWishlistRepository = springDataWishlistRepository;
    }


    @Override
    public Wishlist save(Wishlist wishlist) {
        return springDataWishlistRepository.save(wishlist);
    }

    @Override
    public boolean existsByName(String wishlistName) {
        return springDataWishlistRepository.existsByName(wishlistName);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataWishlistRepository.existsById(id);
    }

    @Override
    public List<Wishlist> findAllWishlists() {
        return springDataWishlistRepository.findAll();
    }

    @Override
    public Optional<Wishlist> findById(long wishlistID) {
        return springDataWishlistRepository.findById(wishlistID);
    }
}
