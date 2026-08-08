package com.cibertec.semana5.services.implementation;

import com.cibertec.semana5.models.UsuarioModel;
import com.cibertec.semana5.repositories.IUsuarioRepository;
import com.cibertec.semana5.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository iUsuarioRepository;
    private final ObjectMapper objectMapper;

    @Override
    public UsuarioModel login(String usuario, String password) {
        System.out.println("Respuesta de repositorio: " + iUsuarioRepository
                .findByUsernameAndPassword(usuario, password));
        System.out.println("Este es el mapeo: " + objectMapper.convertValue(iUsuarioRepository
                .findByUsernameAndPassword(usuario, password), UsuarioModel.class));
        return objectMapper.convertValue(iUsuarioRepository
                .findByUsernameAndPassword(usuario, password), UsuarioModel.class);
    }
}
