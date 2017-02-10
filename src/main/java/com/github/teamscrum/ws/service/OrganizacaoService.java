package com.github.teamscrum.ws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.exception.RecursoNaoEncontradoException;
import com.github.teamscrum.util.CepUtil;
import com.github.teamscrum.ws.model.Organizacao;
import com.github.teamscrum.ws.repository.OrganizacaoRepository;

@Service
public class OrganizacaoService {
	@Autowired
	private OrganizacaoRepository repository;
	
	public Organizacao salvar(Organizacao organizacao) {
		organizacao = prepararEndereco(organizacao);
		repository.save(organizacao);
		return organizacao;
	}

	private Organizacao prepararEndereco(Organizacao organizacao) {
		Map<String, String> mapa = CepUtil.buscarCep("62940000");
		organizacao = preencheEndereco(mapa, organizacao.getNome());
		return organizacao;
	}
	
	private Organizacao preencheEndereco(Map<String, String> mapa, String nome) {
		Organizacao organizacao = new Organizacao(nome, null, null, null, null, mapa.get("localidade"), mapa.get("uf"), mapa.get("cep"));
		return organizacao;
	}
	
	public void atualizar(Organizacao organizacao) {
		Long id = organizacao.getId();
		organizacao = prepararEndereco(organizacao);
		organizacao.setId(id);
		repository.save(organizacao);
	}
	
	public List<Organizacao> listar() {
		return repository.findAll();
	}
	
	public Organizacao buscar(Long id) {
		Organizacao organizacao = repository.findOne(id);
		if(organizacao == null) {
			throw new RecursoNaoEncontradoException("O Recurso nao existe!");
		}
		return organizacao;
	}
}