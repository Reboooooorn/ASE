package de.dhbw.ase.theone.rating;

import java.util.List;

public interface RatingRepository {

    Rating save(Rating rating);

    List<Rating> findAllRatings();
}
