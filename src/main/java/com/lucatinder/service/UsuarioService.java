package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Usuario;

public interface UsuarioService {

	public void guardarUsuario(Usuario u);

	public void eliminarUsuario(Usuario u);

	public List<Usuario> list();

	public void guadarUsuarioAutomativo(Usuario u);

}
