package com.github.teamscrum.ws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.teamscrum.ws.model.Sector;
import com.github.teamscrum.ws.service.SectorService;

@RestController
@RequestMapping("/sectors")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Sector sector)  {
		
		sector = sectorService.save(sector);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sector.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sector>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(sectorService.list());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Sector sector = sectorService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(sector);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		sectorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Sector sector, @PathVariable("id") Long id) {
		sector.setId(id);
		sectorService.update(sector);
		return ResponseEntity.noContent().build();
	}
}
