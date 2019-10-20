package com.lucatinder.service;

import java.util.List;
import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	private IUsuarioDao usuDao;
	public void guardarUsuario(Usuario u) {
		usuDao.save(u);
	}
	/**
	 * Métodos para eliminar, guardarUsuarioAutomático y listado implementados.
	 * @version 1.0
	 * @date 18/10/2019 
	 * @autor Yolanda
	 **/
	public void eliminarUsuario(Usuario u) {
		usuDao.delete(u);
	}

	public List<Usuario> list() {

		  return usuDao.findAll();
	}

	@Override
	public void guadarUsuarioAutomativo(Usuario u) {
		
	    usuDao.save(u);
	}

	
		
	}
	
	
	

