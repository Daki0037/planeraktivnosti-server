package me.danilo.planeraktivnosti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "me.danilo.planeraktivnosti.repository")
public class PlaneraktivnostiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaneraktivnostiApplication.class, args);
	}

}
