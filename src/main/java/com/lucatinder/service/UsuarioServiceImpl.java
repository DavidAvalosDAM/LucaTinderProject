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
	/**
	 * Métodos para eliminar, guardarUsuarioAutomático y listado implementados.
	 * @version 1.0
	 * @date 18/10/2019 
	 * @autor Yolanda
	 **/
	public void eliminarUsuario(Usuario u) {
		usuDao.delete(u);
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
	@Override
	public Usuario devolverUsuarioPorUsername(String userName) {
		
		return usuDao.buscaPorUserName(userName);
	}
	public List<Usuario> devuelveListadoInicialSencillo(int idUsuario) {
		
		return usuDao.devuelveListadoInicialSencillo(idUsuario);
	}


	
		
	}
	
	
	

