package com.github.teamscrum.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.teamscrum.ws.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
