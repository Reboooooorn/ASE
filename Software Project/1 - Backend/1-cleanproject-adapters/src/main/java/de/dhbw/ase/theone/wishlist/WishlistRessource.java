package de.dhbw.ase.theone.wishlist;

import de.dhbw.ase.theone.perfume.PerfumeResource;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WishlistRessource {

    public Long id;
    public String name;
    public List<PerfumeResource> perfumeResourceList;

    public WishlistRessource(String name, List<PerfumeResource> perfumeResourceList) {
        this.name = name;
        this.perfumeResourceList = perfumeResourceList;
    }

    public WishlistRessource(Long id, String name, List<PerfumeResource> perfumeResourceList) {
        this(name,perfumeResourceList);
        this.id = id;
    }
}
