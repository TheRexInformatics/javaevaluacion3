package cl.java.dbd.service;

import org.springframework.stereotype.Service;
import cl.java.dbd.model.Killer;
import cl.java.dbd.repository.KillerRepository;
import java.util.List;


@Service
public class KillerService {
    public final KillerRepository repokiller;

    //
    public KillerService(KillerRepository repokiller){
        this.repokiller = repokiller;
    }

    //
    public List<Killer> findAll() {
        return repokiller.findAll();
    }
    
    //
    public Killer save(Killer kill) {
        return repokiller.save(kill);
    }

    //
    public void delete(Long id) {
        repokiller.deleteById(id);
    }
}
