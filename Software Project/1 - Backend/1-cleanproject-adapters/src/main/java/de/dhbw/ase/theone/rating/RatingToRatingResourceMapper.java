package de.dhbw.ase.theone.rating;

import de.dhbw.ase.theone.manufacturer.ManufacturerToManufacturerResourceMapper;
import de.dhbw.ase.theone.note.NoteToNoteResourceMapper;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeResource;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RatingToRatingResourceMapper implements Function<Rating, RatingResource> {

    PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper;

    @Autowired
    public RatingToRatingResourceMapper(PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper) {
        this.perfumeToPerfumeResourceMapper = perfumeToPerfumeResourceMapper;
    }

    @Override
    public RatingResource apply(Rating rating) {
        return map(rating);
    }

    private RatingResource map(Rating rating) {
        return new RatingResource(
                rating.getUsername(),
                perfumeToPerfumeResourceMapper.apply(rating.getPerfume()),
                rating.getValue_scent(),
                rating.getValue_durability(),
                rating.getValue_sillage(),
                rating.getValue_vial(),
                rating.getValue_charge());
    }

}
