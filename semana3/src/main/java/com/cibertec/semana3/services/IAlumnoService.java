package com.cibertec.semana3.services;

import com.cibertec.semana3.models.Alumno;

public interface IAlumnoService {
    Alumno getAlumnoById(Long id);
    Alumno createAlumno(Alumno alumno);
}
