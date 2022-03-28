package de.dhbw.ase.theone.perfume;

import de.dhbw.ase.theone.collection.Collection;
import de.dhbw.ase.theone.manufacturer.Manufacturer;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import lombok.Getter;

@Getter
public class PerfumeBuilder {

    private String name;
    private long yearOfManufacture;
    private Manufacturer manufacturer;
    private int sizeInMilliliter;

    private Long id;
    private BaseNote baseNote;
    private HeartNote heartNote;
    private HeadNote headNote;
    private Collection collection;

    public PerfumeBuilder(String name, long yearOfManufacture, Manufacturer manufacturer, int sizeInMilliliter) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.sizeInMilliliter = sizeInMilliliter;
    }

    public PerfumeBuilder id(Long id){
        this.id = id;
        return this;
    }

    public PerfumeBuilder baseNote(BaseNote baseNote){
        this.baseNote = baseNote;
        return this;
    }

    public PerfumeBuilder heartNote(HeartNote heartNote){
        this.heartNote = heartNote;
        return this;
    }

    public PerfumeBuilder headNote(HeadNote headNote){
        this.headNote = headNote;
        return this;
    }

    public PerfumeBuilder collection(Collection collection){
        this.collection = collection;
        return this;
    }

    public Perfume build(){
        return new Perfume(this);
    }
}
