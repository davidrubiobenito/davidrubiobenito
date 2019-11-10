package es.babel.curso.alumnos.jpatest.repositories;

import es.babel.curso.alumnos.jpatest.repositories.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> getAlumnosByNombre(String nombre);

}
