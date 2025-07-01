package cl.java.dbd.service;

import cl.java.dbd.model.Killer;
import cl.java.dbd.repository.KillerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KillerServiceTest {

    @InjectMocks
    private KillerService service;

    @Mock
    private KillerRepository repokiller;
    
    public KillerServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Buscar todo")
    void testFindAll(){
        when(repokiller.findAll()).thenReturn(List.of(new Killer(1L, "El Depredador", "Nada lo detiene", "Equipo de caza", "Seguimiento, Analizador de Terreno y Identificador")));
        List<Killer> resultado = service.findAll();
        assertEquals(1, resultado.size());
    }
}
