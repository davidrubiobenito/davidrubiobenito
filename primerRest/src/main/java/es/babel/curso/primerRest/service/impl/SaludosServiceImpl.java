package es.babel.curso.primerRest.service.impl;

import es.babel.curso.primerRest.service.SaludosService;
import org.springframework.stereotype.Service;

@Service("saludosService")
public class SaludosServiceImpl implements SaludosService {

    @Override
    public String getSaludo() {
        return "Hola chicos desde mi servicio";
    }

    @Override
    public String getSaludoById(Long id) {
        return String.format("Hola, el saludo solicitado es el id %s", id);
    }

    @Override
    public String createSaludo(String saludo) {
        return null;
    }

}
