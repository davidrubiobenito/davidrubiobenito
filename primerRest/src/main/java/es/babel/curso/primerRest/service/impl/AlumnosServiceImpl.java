package es.babel.curso.primerRest.service.impl;

import es.babel.curso.primerRest.model.AlumnoDTO;
import es.babel.curso.primerRest.respository.AlumnosRepository;
import es.babel.curso.primerRest.service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Override
    public List<AlumnoDTO> getAll() {
        return alumnosRepository.getAll();
    }

    @Override
    public AlumnoDTO getByIndex(Integer index) {
        return alumnosRepository.getByIndex(index);
    }

    @Override
    public Integer createAlumno(AlumnoDTO alumno) {
        return alumnosRepository.createAlumno(alumno);
    }

    @Override
    public String updateAlumno(AlumnoDTO alumno, Integer index) {
        return alumnosRepository.updateAlumno(alumno, index);
    }

    @Override
    public String deleteAlumno(Integer index) {
        return alumnosRepository.deleteAlumno(index);
    }
}
