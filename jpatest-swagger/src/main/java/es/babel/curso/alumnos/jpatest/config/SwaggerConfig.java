package es.babel.curso.alumnos.jpatest.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String ES_BABEL_CURSO_ALUMNOS_JPATEST_CONTROLLERS = "es.babel.curso.alumnos.jpatest.controllers";

    public Docket apiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage(ES_BABEL_CURSO_ALUMNOS_JPATEST_CONTROLLERS))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("David", "http://localhost:8081", "emai@email.com");
        ApiInfo apiInfo = new ApiInfo("Api test alumnos", "Api con swagger", "1.0.0", "free",
                contact, "free", "https://", Collections.EMPTY_LIST);
        return apiInfo;
    }
}
