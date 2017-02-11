package com.github.teamscrum.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.teamscrum.exception.SectorNotFoundException;
import com.github.teamscrum.ws.model.Sector;
import com.github.teamscrum.ws.repository.SectorRepository;

@Service
public class SectorService {

	@Autowired
	private SectorRepository sectorRepository;
	
	public Sector save(Sector sector) {
		sector.setId(null);
		return sectorRepository.save(sector);
	}
	
	public List<Sector> list() {
		return sectorRepository.findAll();
	}
	
	public Sector findById(Long id) {
		Sector sector = sectorRepository.findOne(id);
		
		if(sector == null) {
			throw new SectorNotFoundException("Setor inexistente.");
		}
		
		return sector;
	}
	
	public void delete(Long id) {
		try {
			sectorRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new SectorNotFoundException("Setor inexistente.");
		}
	}
	
	public void update(Sector sector) {
		checkIfExist(sector);
		sectorRepository.save(sector);
	}
	
	public void checkIfExist(Sector sector) {
		findById(sector.getId());
	}
}
