package com.Projet.Projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController

@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}

}
