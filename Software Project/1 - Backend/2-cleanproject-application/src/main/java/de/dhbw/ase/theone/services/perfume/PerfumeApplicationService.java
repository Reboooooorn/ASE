package de.dhbw.ase.theone.services.perfume;

import de.dhbw.ase.theone.note.NoteRepository;
import de.dhbw.ase.theone.note.types.BaseNote;
import de.dhbw.ase.theone.note.types.HeadNote;
import de.dhbw.ase.theone.note.types.HeartNote;
import de.dhbw.ase.theone.perfume.Perfume;
import de.dhbw.ase.theone.perfume.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeApplicationService {

    private PerfumeRepository perfumeRepository;

    @Autowired
    public PerfumeApplicationService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAllPerfumes();
    }

}
