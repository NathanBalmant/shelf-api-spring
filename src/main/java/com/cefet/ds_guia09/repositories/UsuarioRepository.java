package com.cefet.ds_guia09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.ds_guia09.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
    boolean existsByLogin(String login);

}
