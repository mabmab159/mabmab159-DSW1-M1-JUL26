package com.cibertec.semana4.models;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String marca;
    @Size(min = 3, max = 10)
    private String modelo;
    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$")
    private String placa;
    private String color;
    private LocalDate fechaCompra;
}
