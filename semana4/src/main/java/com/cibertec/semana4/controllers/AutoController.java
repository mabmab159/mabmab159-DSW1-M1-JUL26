package com.cibertec.semana4.controllers;

import com.cibertec.semana4.models.Auto;
import com.cibertec.semana4.services.IAutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
@RequiredArgsConstructor
public class AutoController {
    private final IAutoService autoService;

    @PostMapping
    public ResponseEntity<Auto> create(@RequestBody @Valid Auto auto){
        return ResponseEntity.ok(autoService.create(auto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> get(@PathVariable Long id){
        return ResponseEntity.ok(autoService.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Auto>> getAll(){
        return ResponseEntity.ok(autoService.getAll());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Auto>> getByFilter(Pageable pageable){
        return ResponseEntity.ok(autoService.getByFilter(pageable));
    }
}
