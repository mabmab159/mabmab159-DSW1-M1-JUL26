package com.cibertec.semana4.entities;

import jakarta.persistence.*;
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
    //@ManyToOne
    //private MarcaEntity marca;
    private String modelo;
    private String placa;
    private String color;
    private LocalDate fechaCompra;
}
