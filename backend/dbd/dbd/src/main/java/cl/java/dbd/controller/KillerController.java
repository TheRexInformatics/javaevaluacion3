package cl.java.dbd.controller;
import cl.java.dbd.model.Killer;
import cl.java.dbd.service.KillerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Killers", description = "Operaciones de tipo CRUD para los Killers")
@RestController
@RequestMapping("/api/v1/killers")
public class KillerController {
    private final KillerService service;

    public KillerController(KillerService service){
        this.service = service;
    }
    
    @Operation(summary = "Obtener todos los Killers en una lista", description = "Devuelve una lista con todos los Killers almacenados")
    @ApiResponse(responseCode = "200", description = "Consulta Exitosa")//Sirve para documentar las respuestas esperadas
    @GetMapping
    public List<Killer> getAll(){
        return service.findAll();
    }

    @Operation(summary = "Crea un nuevo Killer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Killer creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación")
    })
    @PostMapping
    public Killer create(@RequestBody Killer kill){
        return service.save(kill);
    }

    @Operation(summary = "Eliminar un Killer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El Killer fue eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "El Killer no existe")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
