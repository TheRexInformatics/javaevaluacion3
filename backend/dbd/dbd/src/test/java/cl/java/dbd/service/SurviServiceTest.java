package cl.java.dbd.service;

import cl.java.dbd.model.Survi;
import cl.java.dbd.repository.SurviRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SurviServiceTest {
    @InjectMocks
    private SurviService service;

    @Mock
    private SurviRepository reposurvi;
    
    public SurviServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Buscar todo")
    void testFindAll(){
        when(reposurvi.findAll()).thenReturn(List.of(new Survi(1L, "ían Badilla", "Manzana", "Solucionador de Problemas, Insultos Provocativos, Agresividad")));
        List<Survi> resultado = service.findAll();
        assertEquals(1, resultado.size());
    }
}
