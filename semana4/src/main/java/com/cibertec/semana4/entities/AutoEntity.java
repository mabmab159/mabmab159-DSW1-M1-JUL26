package com.cibertec.semana4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "auto")
@NoArgsConstructor
@AllArgsConstructor
public class AutoEntity {
    @Id
    private Long id;
    //@NotNull
    private String marca;
    private String modelo;
    private String placa;
    private String color;
    private LocalDate fechaCompra;
}
