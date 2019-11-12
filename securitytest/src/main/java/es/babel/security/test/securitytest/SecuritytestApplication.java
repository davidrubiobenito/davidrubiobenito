package es.babel.security.test.securitytest;

import es.babel.security.test.securitytest.config.CustomSecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableConfigurationProperties(CustomSecurityProperties.class)
public class SecuritytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritytestApplication.class, args);
	}

}
