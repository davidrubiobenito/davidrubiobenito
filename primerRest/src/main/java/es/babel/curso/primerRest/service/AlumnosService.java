package es.babel.curso.primerRest.service;

import es.babel.curso.primerRest.model.AlumnoDTO;

import java.util.List;

public interface AlumnosService {

    List<AlumnoDTO> getAll();

    AlumnoDTO getByIndex(Integer index);

    Integer createAlumno(AlumnoDTO alumno);

    String updateAlumno(AlumnoDTO alumno, Integer index);

    String deleteAlumno(Integer index);

}
