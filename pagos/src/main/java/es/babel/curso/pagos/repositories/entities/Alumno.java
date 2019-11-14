package es.babel.curso.pagos.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    private Long idAlumno;
    private String nombre;
    private String apellidos;

}
