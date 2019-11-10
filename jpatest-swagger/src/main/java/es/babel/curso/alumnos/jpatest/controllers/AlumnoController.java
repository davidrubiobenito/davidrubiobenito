package es.babel.curso.alumnos.jpatest.controllers;

import es.babel.curso.alumnos.jpatest.repositories.entities.Alumno;
import es.babel.curso.alumnos.jpatest.services.AlumnoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value="BABEL Alumnos WEb, JPA, H2")
@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @ApiOperation(value = "LLamada para recuperar la lista de alumnos",
        produces = "application/json",
        response = Alumno.class,
        responseContainer = "List",
        httpMethod = "GET",
        protocols = "HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado de alumnos"),
            @ApiResponse(code = 204, message = "No hay alumnos"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code= 500, message = "Error interno")
    })
    @GetMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> getAllAlumnos(){
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @ApiOperation(value = "LLamada para recuperar un alumno por su identificador ",
            produces = "application/json",
            response = Alumno.class,
            httpMethod = "GET",
            protocols = "HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno encontrado"),
            @ApiResponse(code = 400, message = "Bad Request. Error en la introducción el parámetro"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code= 500, message = "Error interno")
    })
    @GetMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> getAlumnosById(
            @ApiParam(name="id", required = true, value="índice único", example = "1")
            @PathVariable(name="id") Long idAlumno){
        if(alumnoService.getAlumnoById(idAlumno).isPresent()){
            return ResponseEntity.ok(alumnoService.getAlumnoById(idAlumno).get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(value = "LLamada insertar un alumno",
            produces = "application/json",
            response = Alumno.class,
            httpMethod = "POST",
            protocols = "HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno creado"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code= 500, message = "Error interno")
    })
    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> createAlumno(
            @ApiParam(name="alumno", required = true, value="Alumno")
            @RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.createOrUpdateAlumno(alumno));
    }

    @ApiOperation(value = "LLamada actualizar un alumno con un identificador",
            produces = "application/json",
            response = Alumno.class,
            httpMethod = "PUT",
            protocols = "HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno actualizado"),
            @ApiResponse(code = 204, message = "Alumno no encontrado"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code= 500, message = "Error interno")
    })
    @PutMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> updateAlumno(
            @ApiParam(name="alumno", required = true, value="Alumno")
            @RequestBody Alumno alumno,
            @ApiParam(name="id", required = true, value="índice único", example = "1")
            @PathVariable(name="id") Long idAlumno){
        if(alumnoService.getAlumnoById(idAlumno).isPresent()){
            Alumno alumnoToUpdate = Alumno.builder().idAlumno(idAlumno).nombre(alumno.getNombre()).apellidos(alumno.getApellidos()).build();
            return ResponseEntity.ok(alumnoService.createOrUpdateAlumno(alumnoToUpdate));
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(value = "LLamada eliminar un alumno por identificador",
            produces = "application/json",
            response = Alumno.class,
            httpMethod = "DELETE",
            protocols = "HTTPS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alumno eliminado"),
            @ApiResponse(code = 204, message = "Alumno no encontrado"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code= 500, message = "Error interno")
    })
    @DeleteMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAlumno(
            @ApiParam(name="id", required = true, value="índice único", example = "1")
            @PathVariable(name="id") Long idAlumno){
        return ResponseEntity.ok(alumnoService.deleteAlumno(idAlumno));
    }

    /*
    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnosByNombre(@RequestParam(name="nombre") String nombre){
        return ResponseEntity.ok(alumnoService.getAlumnosByNombre(nombre));
    }
    */

}
