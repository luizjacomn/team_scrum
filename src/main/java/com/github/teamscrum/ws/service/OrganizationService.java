package com.github.teamscrum.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.exception.ResourceNotFoundException;
import com.github.teamscrum.ws.model.Organization;
import com.github.teamscrum.ws.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository repository;
	
	public Organization saveUpdate(Organization organization) {
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