package com.cibertec.semana1.controller;

import com.cibertec.semana1.services.IAlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Esperando una vista
@RequestMapping("/alumno") //Es el path base para esta clase
@RequiredArgsConstructor
public class AlumnoController {

    /*@Autowired //Esta prohibido - Es mala practica*/

    //1. Inyeccion por constructor

    /*
    AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }*/

    //2. Inyeccion por lombok

    private final IAlumnoService iAlumnoService; //No se deben inyectar una clase sobre otra - Se hace con interfaces

    @GetMapping("/holaMundo")
    public String holaMundo(){
        return "holamundo";
    }

    @GetMapping("/general")
    public String general(Model model){
        model.addAttribute("alumnos", iAlumnoService.obtenerAlumnos());
        return "general";
    }

    //Retornes en una tabla 2 x 2 - 2 columnas y 2 filas los datos de los alumnos,
    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("alumnos", iAlumnoService.obtenerAlumnosActivos());
        return "lista/listado";
    }
}
