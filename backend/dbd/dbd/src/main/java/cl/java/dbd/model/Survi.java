package cl.java.dbd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
@Schema(description = "Entidad que representa un Killer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Survi {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del Survi", example = "Benjamin Almonacid")
    private String nombre;

    @Schema(description = "Descripción del Survi", example = "Yengan")
    private String descripcion;

    @Schema(description = "Nombre de las Perks", example = "Arrojamiento Rápido, Velocidad Lenta y Piensa Rápido ")
    private String perks;
}