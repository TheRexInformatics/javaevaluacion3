package cl.java.dbd.controller;
import cl.java.dbd.model.Killer;
import cl.java.dbd.service.KillerService;
import cl.java.dbd.service.KillerServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unused")
@WebMvcTest(KillerController.class)
public class KillerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private KillerService service;

    private final ObjectMapper mapper = new ObjectMapper();

    void testGetAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(new Killer(1L, "El Animatronico", "El siempre regresa", "Fazbear Fright", "Help Wanted, Phantom Fear y Haywire")));

        mockMvc.perform(get("/api/v1/killers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("El Animatronico"));
    }

    @Test
    @DisplayName("Test de POST Controller")
    void testPost() throws Exception {
        Killer kill = new Killer( 1L, "Jason", "Levantate Jason!", "Venganza Brutal", "Ahogamiento, Golpe Brutal y Ataque Sorpresa");
        when(service.save(any())).thenReturn(new Killer(1L, "Jason", "Levantate Jason!", "Venganza Brutal", "Ahogamiento, Golpe Brutal y Ataque Sorpresa"));
        mockMvc.perform(post("/api/v1/killers")
                .contentType("aplication/json")
                .content(mapper.writeValueAsString(kill)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nombre").value("Jason"));
    }

    @Test
    @DisplayName("Test de eliminar")
    void testDelete() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/v1/killers/1"))
                .andExpect(status().isOk());
    }
}
