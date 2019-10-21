package com.lucatinder.pruebaunitaria;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.FactoriaUsuarioAutomatico;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucaTinderApplicationTests {
    
	@Autowired
	private UsuarioService service;

	@Autowired
	private IUsuarioDao dao;

/**
 * Prueba Unitaria para comprobar como se insertan usuarios automáticamente
 * @author Yolanda
 * @date 18/10/2019
 * 
 */
	@Test
	public void pruebaInsertarUsuario() {

		Usuario u = FactoriaUsuarioAutomatico.devuelveUsuarioAuto();
		long longitud = dao.count();
		service.guardarUsuario(u);

		assertTrue(longitud == dao.count() - 1);
	}

	/**
	 * Prueba Unitaria para comprobar el guardado de un usuario automático
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	@Test
	public void guardarUsuario() {
		Usuario u = FactoriaUsuarioAutomatico.devuelveUsuarioAuto();
		service.guardarUsuario(u);

	}

	/**
	 * Prueba Unitaria para comprobar el guardado de múltiples usuarios automáticos
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	@Test
	public void guardarListaUsuarios() {
		service.guardarUsuariosAutomaticos(FactoriaUsuarioAutomatico.devuelveUsuariosAuto(5));

	}

	/**
	 * Prueba Unitaria para comprobar el borrado de todos los usuarios introducidos
	 * 
	 * @author Jorge
	 * @date 20/10/2019
	 * 
	 */
	/*@Test
	public void eliminarTodos() {
		service.eliminarTodos();
	}*/
	
	@Test
	public void retornaListaContactos() {
		
	}
}
