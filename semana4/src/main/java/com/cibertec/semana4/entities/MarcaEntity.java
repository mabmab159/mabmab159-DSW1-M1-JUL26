package com.cibertec.semana4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "marca")
@NoArgsConstructor
@AllArgsConstructor
public class MarcaEntity {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    @OneToMany // Como se esta majeando una lista en la entidad Marca, se crea una tabla intermedia
    private List<AutoEntity> autos;
}
