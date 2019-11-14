package es.babel.curso.alumnos.jpatest.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pagos")
public interface PagosResource {

    @RequestMapping(method = RequestMethod.GET, value="/pagos/{id}")
    String getPagosByIdAlumnos(@PathVariable(name="id") Long idAlumno);

    @RequestMapping(method = RequestMethod.POST, value="/pagos/{id}")
    String createPaymentCode(@PathVariable(name="id") Long idAlumno);
}
