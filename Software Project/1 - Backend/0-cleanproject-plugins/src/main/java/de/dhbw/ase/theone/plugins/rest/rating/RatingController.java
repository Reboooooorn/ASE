package de.dhbw.ase.theone.plugins.rest.rating;

import de.dhbw.ase.theone.rating.RatingResource;
import de.dhbw.ase.theone.rating.RatingToRatingResourceMapper;
import de.dhbw.ase.theone.services.rating.RatingApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rating")
public class RatingController {

    private RatingApplicationService ratingApplicationService;
    private RatingToRatingResourceMapper ratingToRatingResourceMapper;

    @Autowired
    public RatingController(RatingApplicationService ratingApplicationService, RatingToRatingResourceMapper ratingToRatingResourceMapper) {
        this.ratingApplicationService = ratingApplicationService;
        this.ratingToRatingResourceMapper = ratingToRatingResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RatingResource> getAllRatings() {
        return this.ratingApplicationService.getAllRatings().stream()
                .map(ratingToRatingResourceMapper)
                .collect(Collectors.toList());
    }

}
