package es.babel.curso.primerRest.service;

import org.springframework.stereotype.Service;

public interface SaludosService {

    String getSaludo();

    String getSaludoById(Long id);

    String createSaludo(String saludo);

}
