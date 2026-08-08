package com.cibertec.semana5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="usuario")
public class UsuarioEntity {
    @Id
    private Long id;
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String documentos;
    private String email;
    @Version
    private Long version;
    @CreatedDate
    private LocalDate createdAt;
}
