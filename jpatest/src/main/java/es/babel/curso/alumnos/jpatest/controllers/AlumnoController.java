package es.babel.curso.alumnos.jpatest.controllers;

import es.babel.curso.alumnos.jpatest.repositories.entities.Alumno;
import es.babel.curso.alumnos.jpatest.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> getAllAlumnos(){
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @GetMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> getAlumnosById(@PathVariable(name="id") Long idAlumno){
        if(alumnoService.getAlumnoById(idAlumno).isPresent()){
            return ResponseEntity.ok(alumnoService.getAlumnoById(idAlumno).get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.createOrUpdateAlumno(alumno));
    }

    @PutMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> updateAlumno(@RequestBody Alumno alumno, @PathVariable(name="id") Long idAlumno){
        if(alumnoService.getAlumnoById(idAlumno).isPresent()){
            Alumno alumnoToUpdate = Alumno.builder().idAlumno(idAlumno).nombre(alumno.getNombre()).apellidos(alumno.getApellidos()).build();
            return ResponseEntity.ok(alumnoService.createOrUpdateAlumno(alumnoToUpdate));
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAlumno(@PathVariable(name="id") Long idAlumno){
        return ResponseEntity.ok(alumnoService.deleteAlumno(idAlumno));
    }

    /*
    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnosByNombre(@RequestParam(name="nombre") String nombre){
        return ResponseEntity.ok(alumnoService.getAlumnosByNombre(nombre));
    }
    */

}
