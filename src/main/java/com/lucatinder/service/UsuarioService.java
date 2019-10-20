package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Usuario;

public interface UsuarioService {

	public void guardarUsuario(Usuario u);

	/**
	 * Métodos para eliminar, guardar y listado de usuario.
	 * @version 1.0
	 * @date 18/10/2019 
	 * @autor Yolanda
	 **/
	public void eliminarUsuario(Usuario u);

	public List<Usuario> list();

	public void guadarUsuarioAutomativo(Usuario u);

}
