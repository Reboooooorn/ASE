package de.dhbw.ase.theone.plugins.rest;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRessource;
import de.dhbw.ase.theone.collection.CollectionToCollectionResourceMapper;
import de.dhbw.ase.theone.perfume.PerfumeResource;
import de.dhbw.ase.theone.perfume.PerfumeResourceToPerfumeMapper;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import de.dhbw.ase.theone.rating.RatingResource;
import de.dhbw.ase.theone.rating.RatingResourceToRatingMapper;
import de.dhbw.ase.theone.rating.RatingToRatingResourceMapper;
import de.dhbw.ase.theone.usecases.*;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRessource;
import de.dhbw.ase.theone.wishlist.WishlistToWishlistResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/uc")
public class UseCaseController {

    private PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper;
    private PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper;

    private CollectionToCollectionResourceMapper collectionToCollectionResourceMapper;

    private WishlistToWishlistResourceMapper wishlistToWishlistResourceMapper;

    private RatingToRatingResourceMapper ratingToRatingResourceMapper;
    private RatingResourceToRatingMapper ratingResourceToRatingMapper;

    private UC1createPerfume uc1createPerfume;
    private UC2createCollection uc2createCollection;
    private UC3createWishlist uc3createWishlist;
    private UC4ratePerfume uc4ratePerfume;
    private UC5addToCollectionOrWishlist uc5addToCollectionOrWishlist;

    public UseCaseController(
            PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper,
            PerfumeResourceToPerfumeMapper perfumeResourceToPerfumeMapper,
            CollectionToCollectionResourceMapper collectionToCollectionResourceMapper,
            WishlistToWishlistResourceMapper wishlistToWishlistResourceMapper,
            RatingToRatingResourceMapper ratingToRatingResourceMapper,
            RatingResourceToRatingMapper ratingResourceToRatingMapper,
            UC1createPerfume uc1createPerfume,
            UC2createCollection uc2createCollection,
            UC3createWishlist uc3createWishlist,
            UC4ratePerfume uc4ratePerfume,
            UC5addToCollectionOrWishlist uc5addToCollectionOrWishlist) {
        this.perfumeToPerfumeResourceMapper = perfumeToPerfumeResourceMapper;
        this.perfumeResourceToPerfumeMapper = perfumeResourceToPerfumeMapper;
        this.collectionToCollectionResourceMapper = collectionToCollectionResourceMapper;
        this.wishlistToWishlistResourceMapper = wishlistToWishlistResourceMapper;
        this.ratingToRatingResourceMapper = ratingToRatingResourceMapper;
        this.ratingResourceToRatingMapper = ratingResourceToRatingMapper;
        this.uc1createPerfume = uc1createPerfume;
        this.uc2createCollection = uc2createCollection;
        this.uc3createWishlist = uc3createWishlist;
        this.uc4ratePerfume = uc4ratePerfume;
        this.uc5addToCollectionOrWishlist = uc5addToCollectionOrWishlist;
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/1")
    public PerfumeResource createPerfume(@RequestBody PerfumeResource perfumeResource) {
        return perfumeToPerfumeResourceMapper.apply(uc1createPerfume.createPerfume(perfumeResourceToPerfumeMapper.apply(perfumeResource)));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/2",
            params = {"collectionName"})
    public CollectionRessource createCollection(@RequestParam String collectionName) {
        return collectionToCollectionResourceMapper.apply(uc2createCollection.createCollection(new Collection(collectionName)));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/3",
            params = {"wishlistName"})
    public WishlistRessource createWishlist(@RequestParam String wishlistName) {
        return wishlistToWishlistResourceMapper.apply(uc3createWishlist.createWishlist(new Wishlist(wishlistName)));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/4")
    public RatingResource createRating(@RequestBody RatingResource ratingResource) {
        return ratingToRatingResourceMapper.apply(uc4ratePerfume.createRating(ratingResourceToRatingMapper.apply(ratingResource)));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/5a")
    public PerfumeResource addPerfumeToCollection(@RequestParam int perfumeID,@RequestParam int collectionID) {
        return perfumeToPerfumeResourceMapper.apply(uc5addToCollectionOrWishlist.addPerfumeToCollection(perfumeID,collectionID));
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/5b")
    public WishlistRessource addPerfumeToWishlist(@RequestParam int perfumeID,@RequestParam int wishlistID) {
        return wishlistToWishlistResourceMapper.apply(uc5addToCollectionOrWishlist.addPerfumeToWishlist(perfumeID,wishlistID));
    }
}
