package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucatinder.model.Usuario;

public interface IPersonaRepo extends JpaRepository<Usuario, Integer> {
	
}
