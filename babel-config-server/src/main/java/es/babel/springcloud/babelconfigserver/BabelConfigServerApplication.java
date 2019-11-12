package es.babel.springcloud.babelconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BabelConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabelConfigServerApplication.class, args);
	}

}
