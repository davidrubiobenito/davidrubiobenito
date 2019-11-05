package es.babel.curso.primerRest.respository.impl;

import es.babel.curso.primerRest.model.AlumnoDTO;
import es.babel.curso.primerRest.respository.AlumnosRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AlumnosRepositoryImpl  implements AlumnosRepository {

    private List<AlumnoDTO> alumnosDB = new ArrayList<>();

    public AlumnosRepositoryImpl() {
        alumnosDB.add(new AlumnoDTO("nomUno", "apeUno", "12-05-1986", "email@uno.es", "111-11-11-11", new Date().toString()));
        alumnosDB.add(new AlumnoDTO("nomDos", "apeDos", "24-06-1992", "email@dos.es", "222-22-22-22", new Date().toString()));
        alumnosDB.add(new AlumnoDTO("nomTres", "apeTres", "02-13-1984", "email@tres.es", "333-33-33-33", new Date().toString()));
        alumnosDB.add(new AlumnoDTO("nomCuatro", "apeCuatro", "06-08-1979", "email@cuatro.es", "444-44-44-44", new Date().toString()));
        alumnosDB.add(new AlumnoDTO("nomCinco", "apeCinco", "30-11-1965", "email@cinco.es", "555-55-55-55", new Date().toString()));
    }

    @Override
    public List<AlumnoDTO> getAll() {
        return alumnosDB;
    }

    @Override
    public AlumnoDTO getByIndex(Integer index) {
        return alumnosDB.get(index);
    }

    @Override
    public Integer createAlumno(AlumnoDTO alumno) {
        alumnosDB.add(alumno);
        return alumnosDB.size()-1;
    }

    @Override
    public String updateAlumno(AlumnoDTO alumno, Integer index) {
        alumnosDB.add(index, alumno);
        return "Alumno actualizado correctamente";
    }

    @Override
    public String deleteAlumno(Integer index) {
        String response = "No se ha podido borrar el alumno";
        if(!alumnosDB.isEmpty()){
            alumnosDB.remove(Math.toIntExact(index - 1));
            response = "Alumno borrado correctamente";
        }
        return response;
    }

}
