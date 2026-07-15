package com.cibertec.semana2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private String codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDate fechaNacimiento;
}
