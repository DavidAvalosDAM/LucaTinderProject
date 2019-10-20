package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Usuario;

public interface UsuarioService {

	public void guardarUsuario(Usuario u);

	public void eliminarUsuario(Usuario u);

	public List<Usuario> list();

	public void guardarUsuariosAutomaticos(List<Usuario> listaUsuariosAuto);
	
	public void eliminarTodos();

}
