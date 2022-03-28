package de.dhbw.ase.theone.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteResource {

    @JsonProperty("id")
    public long id;
    @JsonProperty("type")
    public String type;
    @JsonProperty("name")
    public String name;
    @JsonProperty("smell")
    public String smell;

    public NoteResource(Long id,String type,String name, String smell) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.smell = smell;
    }
}
