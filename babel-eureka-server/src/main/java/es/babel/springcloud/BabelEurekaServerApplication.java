package es.babel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BabelEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabelEurekaServerApplication.class, args);
	}

}
