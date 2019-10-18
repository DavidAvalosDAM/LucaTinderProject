package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucatinder.model.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
	@Query(
			  value = "SELECT * FROM usuarios WHERE nombre = ?1", 
			  nativeQuery = true)
			Usuario buscaPorNombre(String nombre);
}
