package com.lucatinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private IUsuarioDao usuDao;
	
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
	public void guardarUsuariosAutomaticos(List<Usuario> listaUsuariosAuto) {
		
		for (Usuario u:listaUsuariosAuto) {
			usuDao.save(u);
		}
	}

	@Override
	public void eliminarTodos() {
		
		usuDao.deleteAll();
	}


	
		
	}
	
	
	

