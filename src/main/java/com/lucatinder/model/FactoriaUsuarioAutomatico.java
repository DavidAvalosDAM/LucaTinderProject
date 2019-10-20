package com.lucatinder.model;

import java.util.Locale;
import java.util.logging.Logger;

import com.github.javafaker.Faker;

/**Esta clase nos permite crear perfiles falsos de forma automática
 * 
 * @author Jorge
 * @version 1.0
 * @date 20/10/2019 
 */
public class FactoriaUsuarioAutomatico {
	
	private Faker creadorFaker=new Faker(new Locale("es"));
	private Logger log=Logger.getLogger("FactoriaUsuarioAutomatico: -------");
	
	public FactoriaUsuarioAutomatico() {}
	
	/**Método encargado de devolver un único usuario falseado
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * @return Usuario con datos falseados
	 */
	public Usuario devuelveUsuarioAuto() {
		Usuario u=new Usuario();
		log.info("Iniciando Creación de Usuario Falseado");
		
		creadorFaker.name().fullName();
		log.info("Devolviendo Usuario Falseado");
		return u;
	}
}
