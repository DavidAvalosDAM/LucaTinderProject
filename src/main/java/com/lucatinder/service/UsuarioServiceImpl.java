package com.lucatinder.service;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	private IUsuarioDao usuDao;
	
	/**
	 * Guardar usuario en la bbdd
	 */
	public void guardarUsuario(Usuario u) {
		usuDao.save(u);
	}

}
