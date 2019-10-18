package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucatinder.model.Usuario;
/**
 * 
 * @author David
 * Esta interface hereda de JpaRepository, que nos ayuda con el trato con la bbdd
 *
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
	
}
