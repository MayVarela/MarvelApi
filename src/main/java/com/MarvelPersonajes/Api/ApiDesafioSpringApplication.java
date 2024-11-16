package com.MarvelPersonajes.Api;

import com.MarvelPersonajes.Api.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDesafioSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiDesafioSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
