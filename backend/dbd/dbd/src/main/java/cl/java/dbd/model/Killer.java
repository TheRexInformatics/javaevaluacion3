package cl.java.dbd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
@Schema(description = "Entidad que representa un Killer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Killer {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del Killer", example = "Springtrap")
    private String nombre;

    @Schema(description = "Descripción del Killer", example = "El Animatronico que siempre vuelve")
    private String descripcion;

    @Schema(description = "Poder del Killer", example = "Terror de Fazbear")
    private String poder;

    @Schema(description = "Nombre de las Perks", example = "Help Wanted, Phantom Fier y Haywire")
    private String perks;
}
