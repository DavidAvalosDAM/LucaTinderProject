package com.lucatinder.pruebaunitaria;

import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;
/*
 * @autor Yolanda
 * 
 * Para poder acceder a los beans desde los test unitarios deberemos incluir 
 * la siguientes anotaciones en nuestra clase de test
 * @RunWith(SpringRunner.class) proporciona un Spring ApplicationContext y
 * obtiene beans inyectados en su instancia de prueba.
 * @SpringBootTest.-especifica que es una clase de prueba regular que ejecuta 
 * pruebas basadas en Spring Boot.
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LucaTinderApplicationTests {
	
	 @Autowired
	 private UsuarioService service;
	 
	 @Autowired
	 private IUsuarioDao dao;

	@Test
	public void pruebaInsertarUsuario() {
		
		Usuario u = new Usuario ();
		long longitud=dao.count();
	    service.guardarUsuario(u);
	   
	    assertTrue( longitud== dao.count()-1);
	    
	    
	   
	  
		
				
				
	}

}
