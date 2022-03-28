package de.dhbw.ase.theone.rating;

import de.dhbw.ase.theone.perfume.PerfumeResourceToPerfumeMapper;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RatingResourceToRatingMapper implements Function<RatingResource, Rating> {

    PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper;

    @Autowired
    public RatingResourceToRatingMapper(PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper) {
        this.perfumeResourceToPerfumeMapper = perfumeResourceToPerfumeMapper;
    }

    @Override
    public Rating apply(RatingResource ratingResource) {
        return map(ratingResource);
    }

    private Rating map(RatingResource ratingResource) {
        return new Rating(
                perfumeResourceToPerfumeMapper.apply(ratingResource.getPerfumeResource()),
                ratingResource.getUser(),
                ratingResource.getValueScent(),
                ratingResource.getValueDurability(),
                ratingResource.getValueSillage(),
                ratingResource.getValueVial(),
                ratingResource.getValueCharge());
    }

}
