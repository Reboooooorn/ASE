package de.dhbw.ase.theone.plugins.persistence.hibernate.rating;

import de.dhbw.ase.theone.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRatingRepository extends JpaRepository<Rating, Long> {
}
