package com.lucatinder.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	private IUsuarioDao usuDao;
	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * Guardar y eliminar usuario en la bbdd
	 */
	public void guardarUsuario(Usuario u) {
		usuDao.save(u);
	}

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
	
	
	

