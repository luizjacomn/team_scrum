package com.github.teamscrum.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.teamscrum.ws.model.Organizacao;
import com.github.teamscrum.ws.service.OrganizacaoService;

@RestController
public class OrganizacaoController {
	@Autowired
	private OrganizacaoService service; 
	
	@RequestMapping(method = RequestMethod.POST, value = "/organizacoes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void salvar(@RequestBody Organizacao organizacao) {
		service.salvar(organizacao);
		System.out.println("It's work\nID: " + organizacao.getId() + "\nNome: " + organizacao.getNome());
	}
}