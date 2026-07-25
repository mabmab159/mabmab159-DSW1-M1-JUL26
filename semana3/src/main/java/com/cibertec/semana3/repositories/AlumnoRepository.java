package com.cibertec.semana3.repositories;

import com.cibertec.semana3.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository; //Abstrae el motor de base de datos
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
