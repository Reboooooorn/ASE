package de.dhbw.ase.theone.rating;

import de.dhbw.ase.theone.perfume.Perfume;

import java.util.List;

public interface RatingRepository {

    Rating save(Rating rating);

    List<Rating> findAllRatings();
}
