package de.dhbw.ase.theone;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.collection.CollectionRepository;
import de.dhbw.ase.theone.country.Country;
import de.dhbw.ase.theone.country.CountryRepository;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.manufacturer.ManufacturerRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.rating.Rating;
import de.dhbw.ase.theone.rating.RatingRepository;
import de.dhbw.ase.theone.wishlist.Wishlist;
import de.dhbw.ase.theone.wishlist.WishlistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("de.dhbw.*")
@ComponentScan("de.dhbw.*")
@EnableJpaRepositories("de.dhbw.*")
public class TheOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            CountryRepository countryRepository,
            ManufacturerRepository manufacturerRepository,
            NoteRepository noteRepository,
            PerfumeRepository perfumeRepository,
            CollectionRepository collectionRepository,
            WishlistRepository wishlistRepository,
            RatingRepository ratingRepository
    ) {
        return (args) -> {
            Country ukraine = new Country("UKR","Ukraine");
            Country germany = new Country("GER","Deutschland");
            Country france = new Country("FRA","Frankreich");

            countryRepository.save(ukraine);
            countryRepository.save(germany);
            countryRepository.save(france);

            Manufacturer testManufacturer = new Manufacturer("Testhersteller",ukraine);
            manufacturerRepository.save(testManufacturer);

            BaseNote baseNote = new BaseNote("BaseNote","Basisnote");
            noteRepository.save(baseNote);
            HeartNote heartNote = new HeartNote("HeartNote","Herznote");
            noteRepository.save(heartNote);
            HeadNote headNote = new HeadNote("HeadNote","Kopfnote");
            noteRepository.save(headNote);

            Collection collection = new Collection("Neue Collection");
            collectionRepository.save(collection);

            Wishlist wishList = new Wishlist("Neue Wishlist");
            wishlistRepository.save(wishList);

            Perfume perfume = new Perfume("JegorOne",1998,testManufacturer,350,baseNote,heartNote,headNote);
            perfumeRepository.save(perfume);

            Perfume perfume2 = new Perfume("PaddyTwo",2000,testManufacturer,350,baseNote,heartNote,headNote);
            perfumeRepository.save(perfume2);

            Perfume perfume3 = new Perfume("DaveThree",2001,testManufacturer,350,baseNote,heartNote,headNote);
            perfumeRepository.save(perfume3);

            collection.addPerfume(perfume);
            collection.addPerfume(perfume2);
            collectionRepository.save(collection);

            wishList.addPerfume(perfume);
            wishList.addPerfume(perfume3);
            wishlistRepository.save(wishList);

            Rating rating = new Rating(perfume,"Georg Reichert",6,6,6,6,8);
            ratingRepository.save(rating);
        };
    }

}
