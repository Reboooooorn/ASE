package de.dhbw.ase.theone.services.wishlist;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistApplicationService {

    private WishlistRepository wishlistRepository;

    @Autowired
    public WishlistApplicationService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAllWishlists();
    }

}
