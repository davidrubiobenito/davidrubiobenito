package es.babel.curso.primerRest.respository;

import es.babel.curso.primerRest.model.AlumnoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AlumnosRepository {

    List<AlumnoDTO> getAll();

    AlumnoDTO getByIndex(Integer index);

    Integer createAlumno(AlumnoDTO alumno);

    String updateAlumno(AlumnoDTO alumno, Integer index);

    String deleteAlumno(Integer index);

}
