package cl.java.dbd.controller;
import cl.java.dbd.model.Survi;
import cl.java.dbd.service.SurviService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Survis", description = "Operaciones de tipo CRUD para los Survis")
@RestController
@RequestMapping("/api/v1/survis")
public class SurviController {
    private final SurviService service;

    public SurviController(SurviService service){
        this.service = service;
    }
    
    @Operation(summary = "Obtener todos los Survis en una lista", description = "Devuelve una lista con todos los Survis almacenados")
    @ApiResponse(responseCode = "200", description = "Consulta Exitosa")//Sirve para documentar las respuestas esperadas
    @GetMapping
    public List<Survi> getAll(){
        return service.findAll();
    }

    @Operation(summary = "Crea un nuevo Survi")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Survi creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @PostMapping
    public Survi create(@RequestBody Survi srv){
        return service.save(srv);
    }

    @Operation(summary = "Eliminar un Survi")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El Survi fue eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "El Survi no existe")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
