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

import com.github.teamscrum.ws.model.Organization;
import com.github.teamscrum.ws.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	private OrganizationService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody Organization organization) {
		organization = service.saveUpdate(organization);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(organization.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Organization>> listAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Organization> findOne(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findOne(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Organization organization) {
		organization = service.saveUpdate(organization);
		return ResponseEntity.noContent().build();
	}
}