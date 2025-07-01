package cl.java.dbd.controller;
import cl.java.dbd.model.Survi;
import cl.java.dbd.service.SurviService;
import cl.java.dbd.service.SurviServiceTest;
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
public class SurviControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private SurviService service;

    private final ObjectMapper mapper = new ObjectMapper();
    
    void testGetAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(new Survi(1L, "Benjamin Almonacid", "Yengan", "Arrojamiento Rápido, Velocidad Lenta y Piensa Rápido")));

        mockMvc.perform(get("/api/v1/survis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Benjamin Almonacid"));
    }

    @Test
    @DisplayName("Test de POST Controller")
    void testPost() throws Exception {
        Survi srv = new Survi( 1L, "Benjamin Almonacid", "Yengan", "Arrojamiento Rápido, Velocidad Lenta y Piensa Rápido");
        when(service.save(any())).thenReturn(new Survi(1L, "Benjamin Almonacid", "Yengan", "Arrojamiento Rápido, Velocidad Lenta y Piensa Rápido"));
        mockMvc.perform(post("/api/v1/survis")
                .contentType("aplication/json")
                .content(mapper.writeValueAsString(srv)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nombre").value("Benjamin Almonacid"));
    }

    @Test
    @DisplayName("Test de eliminar")
    void testDelete() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/v1/survis/1"))
                .andExpect(status().isOk());
    }
}
