package de.dhbw.ase.theone.services.rating;

import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingApplicationService {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingApplicationService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAllRatings();
    }

}
