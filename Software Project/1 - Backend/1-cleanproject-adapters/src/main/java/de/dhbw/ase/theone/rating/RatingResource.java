package de.dhbw.ase.theone.rating;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.dhbw.ase.theone.perfume.PerfumeResource;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonPropertyOrder({
        "user",
        "perfumeResource",
        "value_scent",
        "value_durability",
        "value_sillage",
        "value_vial",
        "value_charge"
})
public class RatingResource {

    @JsonProperty("user")
    private String user;
    @JsonProperty("perfumeResource")
    private PerfumeResource perfumeResource;
    @JsonProperty("value_scent")
    private Integer valueScent;
    @JsonProperty("value_durability")
    private Integer valueDurability;
    @JsonProperty("value_sillage")
    private Integer valueSillage;
    @JsonProperty("value_vial")
    private Integer valueVial;
    @JsonProperty("value_charge")
    private Integer valueCharge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("perfumeResource")
    public PerfumeResource getPerfumeResource() {
        return perfumeResource;
    }

    @JsonProperty("value_scent")
    public Integer getValueScent() {
        return valueScent;
    }

    @JsonProperty("value_durability")
    public Integer getValueDurability() {
        return valueDurability;
    }

    @JsonProperty("value_sillage")
    public Integer getValueSillage() {
        return valueSillage;
    }

    @JsonProperty("value_vial")
    public Integer getValueVial() {
        return valueVial;
    }

    @JsonProperty("value_charge")
    public Integer getValueCharge() {
        return valueCharge;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public RatingResource(String user, PerfumeResource perfumeResource, Integer valueScent, Integer valueDurability, Integer valueSillage, Integer valueVial, Integer valueCharge) {
        this.user = user;
        this.perfumeResource = perfumeResource;
        this.valueScent = valueScent;
        this.valueDurability = valueDurability;
        this.valueSillage = valueSillage;
        this.valueVial = valueVial;
        this.valueCharge = valueCharge;
    }
}
