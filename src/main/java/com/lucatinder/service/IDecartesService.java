package com.lucatinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucatinder.dao.IDescartesDao;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;


/**
 * Implementamos la interfaz DescartesService
 * Creamos método para devolver listado de descartes.
 * @version 1.0
 * @date 21/10/2019 
 * @autor Yolanda
 **/

public class IDecartesService implements DescartesService {

	@Autowired
	private IDescartesDao descartesDao;

	@Override
	public List<Descartes> devuelveDescartes(int idUsuarioDescartante) {
		
		return  descartesDao.devuelveDescartes(idUsuarioDescartante);
	}
}
