package es.babel.curso.primerRest.controller;

import es.babel.curso.primerRest.model.AlumnoDTO;
import es.babel.curso.primerRest.service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnosController {

    @Autowired
    AlumnosService alumnosService;

    @GetMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlumnoDTO>> getAll(){
        return ResponseEntity.ok(alumnosService.getAll());
    }

    @GetMapping(path = "/alumnos/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlumnoDTO> getByIndex(@PathVariable(name="index") Integer index){
        return ResponseEntity.ok(alumnosService.getByIndex(index));
    }

    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createAlumno(@RequestBody AlumnoDTO alumno){
        return ResponseEntity.ok(alumnosService.createAlumno(alumno));
    }

    @PutMapping(path = "/alumnos/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAlumno(@RequestBody AlumnoDTO alumno, @PathVariable(name="index") Integer index){
        Optional<AlumnoDTO> alumnoFound = Optional.ofNullable(alumnosService.getByIndex(index));
        if(!alumnoFound.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnosService.updateAlumno(alumno, index));
    }

    @DeleteMapping(path = "/alumnos/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAlumno(@PathVariable(name="index") Integer index){
        return ResponseEntity.ok(alumnosService.deleteAlumno(index));
    }

}
