package de.dhbw.ase.theone.wishlist;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRessource;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class WishlistToWishlistResourceMapper implements Function<Wishlist, WishlistRessource> {

    private PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper;

    @Autowired
    public WishlistToWishlistResourceMapper(PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper) {
        this.perfumeToPerfumeResourceMapper = perfumeToPerfumeResourceMapper;
    }

    @Override
    public WishlistRessource apply(Wishlist wishlist) {
        return map(wishlist);
    }

    private WishlistRessource map(Wishlist wishlist) {
        if (null != wishlist.getId()) {
            return new WishlistRessource(wishlist.getId(), wishlist.getName(),wishlist.getIncludedPerfumes().stream().map(perfumeToPerfumeResourceMapper).collect(Collectors.toList()));
        } else {
            return new WishlistRessource(wishlist.getName(),wishlist.getIncludedPerfumes().stream().map(perfumeToPerfumeResourceMapper).collect(Collectors.toList()));
        }

    }
}
