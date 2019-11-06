package es.babel.curso.alumnos.jpatest.services.impl;

import es.babel.curso.alumnos.jpatest.repositories.AlumnoRepository;
import es.babel.curso.alumnos.jpatest.repositories.entities.Alumno;
import es.babel.curso.alumnos.jpatest.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> getAlumnoById(Long idAlumno) {
        return alumnoRepository.findById(idAlumno);
    }

    @Override
    public Alumno createOrUpdateAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public String deleteAlumno(Long idAlumno) {
        String result = "Alumno no encontrado";
        Optional alumnoOptional = alumnoRepository.findById(idAlumno);
        if(alumnoOptional.isPresent()){
            alumnoRepository.deleteById(idAlumno);
            result = "Alumno borrado correctamente";
        }
        return result;
    }

    @Override
    public List<Alumno> getAlumnosByNombre(String nombre) {
        return alumnoRepository.getAlumnosByNombre(nombre);
    }
}
