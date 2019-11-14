package es.babel.curso.pagos.restClients;

import es.babel.curso.pagos.repositories.entities.Alumno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@FeignClient("alumnos")
public interface AlumnosResource {

    @RequestMapping(method = RequestMethod.GET, value="/alumnos")
    List<Alumno> getAllAlumnos();

    @RequestMapping(method = RequestMethod.GET, value="/alumnos/{id}")
    Alumno getAlumnosById(@PathVariable(name="id") Long idAlumno);

    @Component
    @Slf4j
    class HystrixClientFallback implements AlumnosResource {
        @Override
        public List<Alumno> getAllAlumnos() {
            log.error("Error getAll");
            throw new RuntimeException();
        }

        @Override
        public Alumno getAlumnosById(Long idAlumno) {
            log.error("Error getByCompany with id {}", idAlumno);
            return new Alumno();
        }
    }

}
