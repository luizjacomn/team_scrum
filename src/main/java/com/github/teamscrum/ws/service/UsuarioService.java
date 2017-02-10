package com.github.teamscrum.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.ws.model.Usuario;
import com.github.teamscrum.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void save(Usuario usuario) {
		if(usuario.isNovo())
			usuario.setAtivo(true);
		
		repository.save(usuario);
	}
	
}