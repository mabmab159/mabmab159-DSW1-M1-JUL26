package com.cibertec.semana2.services;

import com.cibertec.semana2.models.Alumno;

import java.util.List;

public interface IAlumnoService {
    Alumno obtenerAlumno(String codigo);
    Alumno guardarAlumno(Alumno alumno);
    List<Alumno> obtenerTodos();
}
