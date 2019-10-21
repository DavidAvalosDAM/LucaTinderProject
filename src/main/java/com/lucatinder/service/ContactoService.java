package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucatinder.dao.IContactoDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Usuario;

public class ContactoService implements IContactoService {

	@Autowired
	private IContactoDao contactoDao;
	
	@Override
	public List<Usuario> devuelveListaContactos(int idUsuarioContactante) {
		
		List<Contactos> contactos=contactoDao.devuelveListadoContactos(idUsuarioContactante);
		List<Usuario> listaUsuarios=new ArrayList<>();
		
		for (Contactos c:contactos) {
			listaUsuarios.add(c.getUsuarioContactado());
		}
		return listaUsuarios;
	}

}
