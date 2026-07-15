package com.cibertec.semana2.services.implementation;

import com.cibertec.semana2.models.Alumno;
import com.cibertec.semana2.services.IAlumnoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {
    List<Alumno> alumnos = new ArrayList<>();

    @Override
    public Alumno obtenerAlumno(String codigo) {
        return alumnos.stream()
                .filter(alumno -> alumno.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    @Override
    public List<Alumno> obtenerTodos() {
        return alumnos;
    }
}
