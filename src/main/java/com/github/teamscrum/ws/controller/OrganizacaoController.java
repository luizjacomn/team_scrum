package com.github.teamscrum.ws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.teamscrum.ws.model.Organizacao;
import com.github.teamscrum.ws.service.OrganizacaoService;

@RestController
@RequestMapping("/organizacoes")
public class OrganizacaoController {

	@Autowired
	private OrganizacaoService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> salvar(@RequestBody Organizacao organizacao) {
		organizacao = service.salvar(organizacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(organizacao.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Organizacao>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Organizacao> buscar(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Organizacao organizacao) {
		service.atualizar(organizacao);
		return ResponseEntity.noContent().build();
	}
}