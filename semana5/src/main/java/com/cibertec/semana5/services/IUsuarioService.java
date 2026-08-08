package com.cibertec.semana5.services;

import com.cibertec.semana5.models.UsuarioModel;

public interface IUsuarioService {
    UsuarioModel login(String usuario, String password);
}
