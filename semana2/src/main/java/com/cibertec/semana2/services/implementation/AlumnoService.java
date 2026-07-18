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

    @Override
    public void eliminarAlumno(String codigo) {
        //Eliminar un alumno de la List<Alumnos> en base a su codigo; // 3 minutos - 7:49
        alumnos.removeIf(alumno -> alumno.getCodigo().equals(codigo));
    }

    @Override
    public Alumno actualizarAlumno(String codigo, Alumno alumnoActualizado) { // 4 minutos - 8:00
        //1. Opcion 1 usando lambdas
        // alumnos.replaceAll(alumno -> alumno.getCodigo().equals(codigo) ? alumnoActualizado : alumno);
        //2. For
        for (Alumno alumno : alumnos) {
            if(alumno.getCodigo().equals(codigo)) {
                alumno.setNombre(alumnoActualizado.getNombre());
                alumno.setApellido(alumnoActualizado.getApellido());
                alumno.setCorreo(alumnoActualizado.getCorreo());
                alumno.setFechaNacimiento(alumnoActualizado.getFechaNacimiento());
                break;
            }
        }
        return alumnoActualizado;
    }
}
