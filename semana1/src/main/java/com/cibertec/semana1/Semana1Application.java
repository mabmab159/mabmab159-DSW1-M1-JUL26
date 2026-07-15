package com.cibertec.semana1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Es un metodo comprimido que tiene 3 metodos por detras
public class Semana1Application {

	public static void main(String[] args) { //Perdura fuera de la instancia o perdura a traves de la ejecucion del programa
		SpringApplication.run(Semana1Application.class, args);
	}
}
