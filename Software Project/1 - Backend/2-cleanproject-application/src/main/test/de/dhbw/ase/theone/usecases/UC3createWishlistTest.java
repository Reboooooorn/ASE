package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UC3createWishlistTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private UC3createWishlist uc3createWishlist;

    String wishlistName = "Test Wunschliste";

    @Test
    void createWishlist() {
        Wishlist wishlist = new Wishlist(wishlistName);
        doReturn(wishlist).when(this.wishlistRepository).save(wishlist);
        Wishlist createdWishlist = uc3createWishlist.createWishlist(wishlist);
        verify(this.wishlistRepository, times(1)).save(any(Wishlist.class));
        assertEquals(createdWishlist, wishlist);
    }
}
