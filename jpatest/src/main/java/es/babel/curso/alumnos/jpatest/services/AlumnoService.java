package es.babel.curso.alumnos.jpatest.services;

import es.babel.curso.alumnos.jpatest.repositories.entities.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> getAllAlumnos();

    Optional<Alumno> getAlumnoById(Long idAlumno);

    Alumno createOrUpdateAlumno(Alumno alumno);

    String deleteAlumno(Long idAlumno);

    List<Alumno> getAlumnosByNombre(String nombre);

}
