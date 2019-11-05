package es.babel.curso.primerRest.controller;

import es.babel.curso.primerRest.service.SaludosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaludoController {

    @Autowired
    @Qualifier("saludosService")
    SaludosService saludosService;

    @GetMapping("/saludos")
    public ResponseEntity<String> getting(@RequestParam(name = "name") String nombre){
        //return ResponseEntity.ok(String.format("Hola mundo, me llamo %s", nombre));
        return ResponseEntity.ok(saludosService.getSaludo());
    }

    @GetMapping("/saludos/{id}")
    public ResponseEntity<String> gettingById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(String.format("El id solicitado es %s", id));
    }

    @PostMapping("/saludos")
    public ResponseEntity<String> createGetting(String mensaje){
        return ResponseEntity.ok(mensaje);
    }

}
