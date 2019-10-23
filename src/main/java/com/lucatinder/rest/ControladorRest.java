package com.lucatinder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;

@RestController

public class ControladorRest {
	
	@Autowired
	private UsuarioService usu;

	@PostMapping("/usuarios")
	public void guardaUsuario(@RequestBody Usuario usuario){
		usu.guardarUsuario(usuario);
	
	
}
}