package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class UC3createWishlist {

    private WishlistRepository wishlistRepository;

    @Autowired
    public UC3createWishlist(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist createWishlist(Wishlist wishlist){
        if(!wishlistRepository.existsByName(wishlist.getName())){
            return wishlistRepository.save(wishlist);
        }
        throw new ValidationException(String.format("Wunschliste %s ist bereits vorhanden",wishlist.getName()));
    }
}
