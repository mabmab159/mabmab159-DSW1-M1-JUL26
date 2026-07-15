package com.cibertec.semana2.controllers;

import com.cibertec.semana2.models.Alumno;
import com.cibertec.semana2.services.IAlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alumno")
public class AlumnoController {
    private final IAlumnoService iAlumnoService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("alumnos", iAlumnoService.obtenerTodos());
        return "index";
    }

    @GetMapping("/{codigo}")
    public String obtenerAlumno(Model model, @PathVariable String codigo) {
        Alumno alumno = iAlumnoService.obtenerAlumno(codigo);
        model.addAttribute("alumno", alumno);
        return "alumno";
    }

    @GetMapping("/nuevo")
    public String nuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        iAlumnoService.guardarAlumno(alumno);
        return "redirect:/alumno";
    }
}
