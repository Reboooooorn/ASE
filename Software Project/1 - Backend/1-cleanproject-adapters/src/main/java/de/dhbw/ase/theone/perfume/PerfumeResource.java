package de.dhbw.ase.theone.perfume;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.dhbw.ase.theone.manufacturer.ManufacturerResource;
import de.dhbw.ase.theone.note.NoteResource;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonPropertyOrder({
        "id",
        "name",
        "yearOfManufacture",
        "manufacturer",
        "sizeInMilliliter",
        "basicNote",
        "heartNote",
        "headNote",
        "collectionName"
})
public class PerfumeResource {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("yearOfManufacture")
    private Long yearOfManufacture;
    @JsonProperty("manufacturer")
    private ManufacturerResource manufacturer;
    @JsonProperty("sizeInMilliliter")
    private Integer sizeInMilliliter;
    @JsonProperty("basicNote")
    private NoteResource basicNote;
    @JsonProperty("heartNote")
    private NoteResource heartNote;
    @JsonProperty("headNote")
    private NoteResource headNote;
    @JsonProperty("collectionName")
    private String collectionName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("yearOfManufacture")
    public Long getYearOfManufacture() {
        return yearOfManufacture;
    }

    @JsonProperty("manufacturer")
    public ManufacturerResource getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("sizeInMilliliter")
    public Integer getSizeInMilliliter() {
        return sizeInMilliliter;
    }

    @JsonProperty("basicNote")
    public NoteResource getBasicNote() {
        return basicNote;
    }

    @JsonProperty("heartNote")
    public NoteResource getHeartNote() {
        return heartNote;
    }

    @JsonProperty("headNote")
    public NoteResource getHeadNote() {
        return headNote;
    }

    @JsonProperty("collectionName")
    public String getCollectionName() {
        return collectionName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public PerfumeResource(Long id, String name, Long yearOfManufacture, ManufacturerResource manufacturer, Integer sizeInMilliliter, NoteResource basicNote, NoteResource heartNote, NoteResource headNote, String collectionName) {
        this.id = id;
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.sizeInMilliliter = sizeInMilliliter;
        this.basicNote = basicNote;
        this.heartNote = heartNote;
        this.headNote = headNote;
        this.collectionName = collectionName;
    }

    public PerfumeResource(String name, Long yearOfManufacture, ManufacturerResource manufacturer, Integer sizeInMilliliter, NoteResource basicNote, NoteResource heartNote, NoteResource headNote, String collectionName) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.sizeInMilliliter = sizeInMilliliter;
        this.basicNote = basicNote;
        this.heartNote = heartNote;
        this.headNote = headNote;
        this.collectionName = collectionName;
    }
}
