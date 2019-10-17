package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucatinder.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
	
}
