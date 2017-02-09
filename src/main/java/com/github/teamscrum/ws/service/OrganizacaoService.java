package com.github.teamscrum.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.ws.model.Organizacao;
import com.github.teamscrum.ws.repository.OrganizacaoRepository;

@Service
public class OrganizacaoService {
	@Autowired
	private OrganizacaoRepository repository;
	
	public void salvar(Organizacao organizacao) {
		repository.save(organizacao);
	}
}
