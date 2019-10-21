package com.lucatinder.service;

import java.util.List;

import com.lucatinder.model.Usuario;

public interface IContactoService {

	public List<Usuario> devuelveListaContactos(int idUsuarioContactante);
}
