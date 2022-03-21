package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class UC4ratePerfume {

    private RatingRepository ratingRepository;
    private PerfumeRepository perfumeRepository;

    @Autowired
    public UC4ratePerfume(RatingRepository ratingRepository, PerfumeRepository perfumeRepository) {
        this.ratingRepository = ratingRepository;
        this.perfumeRepository = perfumeRepository;
    }

    public Rating createRating(Rating handoverRating){
        if(perfumeRepository.existsById(handoverRating.getPerfume().getId())){
            Optional<Perfume> targetPerfume = perfumeRepository.findById(handoverRating.getPerfume().getId());
            if(targetPerfume.isPresent()){
                Rating rating = new Rating(
                        perfumeRepository.findById(handoverRating.getPerfume().getId()).get(),
                        handoverRating.getUsername(),
                        handoverRating.getValue_scent(),
                        handoverRating.getValue_durability(),
                        handoverRating.getValue_sillage(),
                        handoverRating.getValue_vial(),
                        handoverRating.getValue_charge());
                return ratingRepository.save(rating);
            }
        }
        throw new ValidationException(String.format("Parfum %s wurde nicht gefunden!",handoverRating.getPerfume().getName()));
    }
}
