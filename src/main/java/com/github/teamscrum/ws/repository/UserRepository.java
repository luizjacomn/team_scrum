package com.github.teamscrum.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.teamscrum.ws.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
