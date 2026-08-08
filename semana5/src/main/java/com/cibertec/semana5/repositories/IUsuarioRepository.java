package com.cibertec.semana5.repositories;

import com.cibertec.semana5.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("select u from usuario u where u.usuario = :username and u.password = :password")
    UsuarioEntity findByUsernameAndPassword(String username, String password);
}
