package de.dhbw.ase.theone.plugins.rest.perfume;

import de.dhbw.ase.theone.perfume.PerfumeResource;
import de.dhbw.ase.theone.perfume.PerfumeToPerfumeResourceMapper;
import de.dhbw.ase.theone.services.perfume.PerfumeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/perfume")
public class PerfumeController {

    private PerfumeApplicationService perfumeApplicationService;
    private PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper;

    @Autowired
    public PerfumeController(PerfumeApplicationService perfumeApplicationService, PerfumeToPerfumeResourceMapper perfumeToPerfumeResourceMapper) {
        this.perfumeApplicationService = perfumeApplicationService;
        this.perfumeToPerfumeResourceMapper = perfumeToPerfumeResourceMapper;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<PerfumeResource> getPerfumes() {
        return this.perfumeApplicationService.getAllPerfumes().stream()
                .map(perfumeToPerfumeResourceMapper)
                .collect(Collectors.toList());
    }

}
