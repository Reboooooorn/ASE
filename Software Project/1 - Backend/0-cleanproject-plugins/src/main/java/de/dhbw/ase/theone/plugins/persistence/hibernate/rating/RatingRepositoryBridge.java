package de.dhbw.ase.theone.plugins.persistence.hibernate.rating;

import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingRepositoryBridge implements RatingRepository {

    private SpringDataRatingRepository springDataRatingRepository;

    @Autowired
    public RatingRepositoryBridge(SpringDataRatingRepository springDataRatingRepository) {
        this.springDataRatingRepository = springDataRatingRepository;
    }


    @Override
    public Rating save(Rating rating) {
        return springDataRatingRepository.save(rating);
    }

    @Override
    public List<Rating> findAllRatings() {
        return springDataRatingRepository.findAll();
    }
}
