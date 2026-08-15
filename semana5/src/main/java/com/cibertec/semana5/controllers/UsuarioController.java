package com.cibertec.semana5.controllers;

import com.cibertec.semana5.models.UsuarioModel;
import com.cibertec.semana5.models.UsuarioModelResponse;
import com.cibertec.semana5.security.JWTAuthenticationConfig;
import com.cibertec.semana5.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
    private final IUsuarioService iUsuarioService;
    private final JWTAuthenticationConfig jwtAuthenticationConfig;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getUsuarios() {
        List<UsuarioModel> list = new ArrayList<>();
        list.add(new UsuarioModel("miguel", "miguel"));
        list.add(new UsuarioModel("jose", "jose"));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/unprotected")
    public ResponseEntity<List<UsuarioModel>> getUsuariosUnprotected() {
        List<UsuarioModel> list = new ArrayList<>();
        list.add(new UsuarioModel("miguel", "miguel"));
        list.add(new UsuarioModel("jose", "jose"));
        return ResponseEntity.ok(list);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioModelResponse> login(@RequestBody UsuarioModel usuario) {
        UsuarioModel usuarioModel = iUsuarioService.login(usuario.getUsuario(), usuario.getPassword());
        if (usuarioModel == null) {
            throw new UsernameNotFoundException("Credenciales erradas");
        }
        return ResponseEntity.ok(
                new UsuarioModelResponse(jwtAuthenticationConfig.getJWTToken(usuarioModel.getUsuario(),
                        usuarioModel.getUsuario(), usuarioModel.getUsuario()))
        );
    }
}
