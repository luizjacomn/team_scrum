package com.github.teamscrum.ws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.exception.ResourceNotFoundException;
import com.github.teamscrum.util.CepUtil;
import com.github.teamscrum.ws.model.Organization;
import com.github.teamscrum.ws.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository repository;
	
	public Organization save(Organization organization) {
		organization = prepareAddress(organization);
		repository.save(organization);
		return organization;
	}

	private Organization prepareAddress(Organization organization) {
		Map<String, String> mapa = CepUtil.findCep("62940000");
		organization = fillAddress(mapa, organization.getName());
		return organization;
	}
	
	private Organization fillAddress(Map<String, String> mapa, String nome) {
		Organization organization = new Organization(nome, null, null, null, null, mapa.get("localidade"), mapa.get("uf"), mapa.get("cep"));
		return organization;
	}
	
	public Organization update(Organization organization) {
		Long id = organization.getId();
		organization = prepareAddress(organization);
		organization.setId(id);
		return repository.save(organization);
	}
	
	public List<Organization> listAll() {
		return repository.findAll();
	}
	
	public Organization findOne(Long id) {
		Organization organization = repository.findOne(id);
		if(organization == null) {
			throw new ResourceNotFoundException("O Recurso nao existe!");
		}
		return organization;
	}
}