package com.lucatinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucatinder.model.Usuario;
/**
 * 
 * @author David
 * Esta interface hereda de JpaRepository, que nos ayuda con el trato con la bbdd
 *
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
	@Query(
			  value = "SELECT * FROM usuarios WHERE nombre = ?1", 
			  nativeQuery = true)
			public Usuario buscaPorNombre(String nombre);
	/**
	 * Esta query Personalizada nos devuelve 20 usuarios que no correspondan con la id
	 * del usuario que se requiere por parámetro
	 * 
	 * @author Jorge
	 * @param idUsuario
	 * @return Lista de usuarios con un algoritmo sencillo
	 */
	@Query(
			  value = "SELECT * FROM usuarios WHERE idUsuario<>?1 LIMIT 20", 
			  nativeQuery = true)
			public List<Usuario> devuelveListadoInicialSencillo(int idUsuario);

	}
