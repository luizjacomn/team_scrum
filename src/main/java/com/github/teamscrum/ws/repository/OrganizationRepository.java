package com.github.teamscrum.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.teamscrum.ws.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {}