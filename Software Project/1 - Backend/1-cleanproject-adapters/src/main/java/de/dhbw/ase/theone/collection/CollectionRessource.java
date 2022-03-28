package de.dhbw.ase.theone.collection;

import de.dhbw.ase.theone.perfume.PerfumeResource;
import lombok.Data;

import java.util.List;

@Data
public class CollectionRessource {
    public Long id;
    public String name;
    public List<PerfumeResource> perfumeResourceList;

    public CollectionRessource(String name, List<PerfumeResource> perfumeResourceList) {
        this.name = name;
        this.perfumeResourceList = perfumeResourceList;
    }

    public CollectionRessource(Long id, String name, List<PerfumeResource> perfumeResourceList) {
        this(name,perfumeResourceList);
        this.id = id;
    }
}
