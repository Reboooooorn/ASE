package de.dhbw.ase.theone.plugins.rest.wishlist;

import de.dhbw.ase.theone.services.wishlist.WishlistApplicationService;
import de.dhbw.ase.theone.wishlist.WishlistRessource;
import de.dhbw.ase.theone.wishlist.WishlistToWishlistResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/wishlist")
public class WishlistController {

    private WishlistApplicationService wishlistApplicationService;
    private WishlistToWishlistResourceMapper wishlistToWishlistResourceMapper;

    @Autowired
    public WishlistController(WishlistApplicationService wishlistApplicationService, WishlistToWishlistResourceMapper wishlistToWishlistResourceMapper) {
        this.wishlistApplicationService = wishlistApplicationService;
        this.wishlistToWishlistResourceMapper = wishlistToWishlistResourceMapper;
    }

    @GetMapping(path = "")
    public List<WishlistRessource> getAllCollections() {
        return this.wishlistApplicationService.getAllWishlists().stream()
                .map(wishlistToWishlistResourceMapper)
                .collect(Collectors.toList());
    }

}
