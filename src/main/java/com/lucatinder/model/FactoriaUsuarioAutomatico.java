package com.lucatinder.model;

import java.util.Locale;

import com.github.javafaker.Faker;

/**Esta clase nos permite crear perfiles falsos de forma automática
 * 
 * @author Jorge
 *
 */
public class FactoriaUsuarioAutomatico {
	
	private Faker creadorFaker=new Faker(new Locale("es"));
	
	public FactoriaUsuarioAutomatico() {}
	
	/**Método encargado de devolver un único usuario falseado
	 * 
	 * @author Jorge
	 * @return Usuario con datos falseados
	 */
	public Usuario devuelveUsuarioAuto() {
		
		Usuario u=new Usuario();
		
		return u;
	}
}
