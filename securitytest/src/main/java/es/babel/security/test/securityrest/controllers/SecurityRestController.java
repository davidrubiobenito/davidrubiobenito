package es.babel.security.test.securityrest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityRestController {

    @GetMapping()
    public ResponseEntity<String> getSecurityGroup(@RequestParam(name="name") String name){
        return ResponseEntity.ok(String.format("El grupo de seguridad es %s", name));
    }
}
