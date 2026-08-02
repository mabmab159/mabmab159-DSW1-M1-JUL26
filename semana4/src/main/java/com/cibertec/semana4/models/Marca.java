package com.cibertec.semana4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
}
