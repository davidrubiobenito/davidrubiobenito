package es.babel.curso.pagos.controllers;

import es.babel.curso.pagos.repositories.entities.Alumno;
import es.babel.curso.pagos.restClients.AlumnosResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    private AlumnosResource alumnosResource;

    @GetMapping("/{id}")
    public ResponseEntity<String> getPagosByIdAlumnos(@PathVariable(name="id") Long idAlumno){
        return ResponseEntity.ok(String.format("No tiene pagos pendiente: %s", idAlumno));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createPaymentCode(@PathVariable(name="id") Long idAlumno){
        return ResponseEntity.ok(String.format("El código de pago para el alumno [%s] es: %s: ", idAlumno, UUID.randomUUID().toString()));
    }


    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAllAlumnos(){
        return ResponseEntity.ok(alumnosResource.getAllAlumnos());
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumnosById(@PathVariable(name="id") Long idAlumno){
        return ResponseEntity.ok(alumnosResource.getAlumnosById(idAlumno));
    }


}
