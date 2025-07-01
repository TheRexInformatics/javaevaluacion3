package cl.java.dbd.service;

import org.springframework.stereotype.Service;
import cl.java.dbd.model.Survi;
import cl.java.dbd.repository.SurviRepository;
import java.util.List;


@Service
public class SurviService {
    public final SurviRepository reposurvi;

    //
    public SurviService(SurviRepository reposurvi){
        this.reposurvi = reposurvi;
    }

    //
    public List<Survi> findAll() {
        return reposurvi.findAll();
    }
    
    //
    public Survi save(Survi srv) {
        return reposurvi.save(srv);
    }

    //
    public void delete(Long id) {
        reposurvi.deleteById(id);
    }
    
}
