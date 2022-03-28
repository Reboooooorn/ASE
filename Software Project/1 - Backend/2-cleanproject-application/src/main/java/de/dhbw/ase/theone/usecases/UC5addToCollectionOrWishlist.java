package de.dhbw.ase.theone.usecases;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class UC5addToCollectionOrWishlist {

    private CollectionRepository collectionRepository;
    private WishlistRepository wishlistRepository;
    private PerfumeRepository perfumeRepository;

    @Autowired
    public UC5addToCollectionOrWishlist(CollectionRepository collectionRepository, WishlistRepository wishlistRepository, PerfumeRepository perfumeRepository) {
        this.collectionRepository = collectionRepository;
        this.wishlistRepository = wishlistRepository;
        this.perfumeRepository = perfumeRepository;
    }

    public Perfume addPerfumeToCollection(long perfumeID, long collectionID){
        if(perfumeRepository.existsById(perfumeID)){
            if(collectionRepository.existsById(collectionID)){
                Optional<Collection> foundCollection = collectionRepository.findById(collectionID);
                Optional<Perfume> foundPerfume = perfumeRepository.findById(perfumeID);
                if(foundCollection.isPresent() && foundPerfume.isPresent()){
                    if(!foundCollection.get().getPerfumeList().contains(foundPerfume.get())){
                        Perfume perfume = foundPerfume.get();
                        perfume.setCollection(foundCollection.get());
                        return perfumeRepository.save(perfume);
                    }

                }
            }
            throw new ValidationException(String.format("Kollektion mit der ID '%d' wurde nicht gefunden!",collectionID));
        }
        throw new ValidationException(String.format("Parfum mit der ID '%d' wurde nicht gefunden!",perfumeID));
    }

    public Wishlist addPerfumeToWishlist(long perfumeID, long wishlistID){
        if(perfumeRepository.existsById(perfumeID)){
            if(wishlistRepository.findById(wishlistID) != null){
                Optional<Wishlist> foundWishlist = wishlistRepository.findById(wishlistID);
                Optional<Perfume> foundPerfume = perfumeRepository.findById(perfumeID);
                if(foundWishlist.isPresent() && foundPerfume.isPresent()){
                    if(!foundWishlist.get().getIncludedPerfumes().contains(foundPerfume.get())){
                        Wishlist wishlist = foundWishlist.get();
                        wishlist.addPerfume(foundPerfume.get());
                        return wishlistRepository.save(wishlist);
                    }
                    throw new ValidationException(String.format("Parfum mit der ID '%d' bereits in der Wunschliste vorhanden!",wishlistID));
                }
            }
            throw new ValidationException(String.format("Wunschliste mit der ID '%d' wurde nicht gefunden!",wishlistID));
        }
        throw new ValidationException(String.format("Parfum mit der ID '%d' wurde nicht gefunden!",perfumeID));
    }
}
