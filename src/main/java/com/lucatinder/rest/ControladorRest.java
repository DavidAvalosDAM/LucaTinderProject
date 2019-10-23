package com.lucatinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;

@RestController

public class ControladorRest {
	
	@Autowired
	private UsuarioService usu;
	
	/**
	 * Este método recibe un usuario JSON y lo guarda en la BBDD.
	 * @author Yolanda
	 * @version 1.0
	 * @date 22/10/2019
	 */
	@PostMapping("/restAlta")
	public void altaUsuario(@RequestBody Usuario usuario){
		usu.guardarUsuario(usuario);
	
	}
	
	/**
	 * Este método recibe un usuario JSON y lo elimina de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 22/10/2019
	 */
	@PostMapping("/restBaja")
	public void bajaUsuario(@RequestBody Usuario usuario) {
		usu.eliminarUsuario(usuario);
	}
	
	
	
}