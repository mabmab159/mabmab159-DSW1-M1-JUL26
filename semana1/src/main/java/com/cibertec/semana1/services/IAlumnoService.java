package com.cibertec.semana1.services;

import com.cibertec.semana1.model.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<String> obtenerAlumnos();

    List<Alumno> obtenerAlumnosActivos();
}
