package com.lucatinder.service;

import java.util.List;
import com.lucatinder.model.Descartes;

/**
 * Creamos la interfaz Descartes.
 * Método para que nos devuelva un listado de descartes.
 * @version 1.0
 * @date 21/10/2019
 * @autor Yolanda
 **/

public interface DescartesService {

	public List<Descartes> devuelveDescartes(int idUsuarioDescartante);

}
