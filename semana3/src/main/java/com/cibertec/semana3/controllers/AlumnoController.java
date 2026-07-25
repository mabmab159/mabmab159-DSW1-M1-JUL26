package com.cibertec.semana3.controllers;

import com.cibertec.semana3.models.Alumno;
import com.cibertec.semana3.services.IAlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final IAlumnoService iAlumnoService;

    @GetMapping("/hola")
    public ResponseEntity<Alumno> holaMundo(){
        /*return Alumno.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .email("jp@jp.com")
                .fechaNacimiento(LocalDate.now())
                .build();*/
        return ResponseEntity.ok(Alumno.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .email("jp@jp.com")
                .fechaNacimiento(LocalDate.now())
                .build());
        /*return new ResponseEntity<>(Alumno.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .email("jp@jp.com")
                .fechaNacimiento(LocalDate.now())
                .build(), HttpStatus.OK);*/
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Long id){
        return ResponseEntity.ok(iAlumnoService.getAlumnoById(id));
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(iAlumnoService.createAlumno(alumno));
    }
}
