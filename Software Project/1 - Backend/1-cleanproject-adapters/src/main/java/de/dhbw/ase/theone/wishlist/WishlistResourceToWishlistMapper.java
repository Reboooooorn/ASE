package de.dhbw.ase.theone.wishlist;

import de.dhbw.ase.theone.perfume.PerfumeResourceToPerfumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class WishlistResourceToWishlistMapper implements Function<WishlistRessource, Wishlist> {

    PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper;

    @Autowired
    public WishlistResourceToWishlistMapper(PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper) {
        this.perfumeResourceToPerfumeMapper = perfumeResourceToPerfumeMapper;
    }

    @Override
    public Wishlist apply(WishlistRessource wishlistRessource) {
        return map(wishlistRessource);
    }

    private Wishlist map(WishlistRessource wishlistRessource) {
        return new Wishlist(wishlistRessource.getName(),wishlistRessource.perfumeResourceList.stream().map(perfumeResourceToPerfumeMapper).collect(Collectors.toSet()));
    }

}
