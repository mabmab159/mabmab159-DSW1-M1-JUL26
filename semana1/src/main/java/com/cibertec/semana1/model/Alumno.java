package com.cibertec.semana1.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor con todos los parametros
@Getter //Genera los metodos get
@Setter //Genera los metodos set
@ToString //Genera el metodo toString
public class Alumno {
    private String codigo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private boolean isActivo;

    //Constructor vacio
    //Constructor con todos los parametros
    //Getter y Setter
    //toString
    //HashCode
    //Equals
}
