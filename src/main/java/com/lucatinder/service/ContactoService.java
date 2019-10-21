package com.lucatinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.dao.IContactoDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Usuario;

@Service
public class ContactoService implements IContactoService {

	@Autowired
	private IContactoDao contactoDao;
	
	/**
	 * Este método devuelve una lista de contactos en base al id de un Usuario dado
	 * @author Jorge
	 * @param idUsuarioContactante
	 */
	@Override
	public List<Usuario> devuelveListaContactos(int idUsuarioContactante) {
		
		List<Contactos> contactos=contactoDao.devuelveListadoContactos(idUsuarioContactante);
		List<Usuario> listaUsuarios=new ArrayList<>();
		
		for (Contactos c:contactos) {
			listaUsuarios.add(c.getUsuarioContactado());
		}
		return listaUsuarios;
	}

	/**
	 * 
	 * @author Jorge
	 * @param idUsuarioContactante
	 */
	@Override
	public void contactar(Contactos c) {
		contactoDao.save(c);
		
	}

}
