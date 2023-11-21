package ceu.dam.ad.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AppRestService {
	public static void main(String[] args) {
		SpringApplication.run(AppRestService.class, args);
	}
}
