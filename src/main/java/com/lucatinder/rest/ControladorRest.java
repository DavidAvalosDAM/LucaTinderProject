package com.lucatinder.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;

@RestController
@CrossOrigin
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
	public void altaUsuario(Usuario usuario){
		usu.guardarUsuario(usuario);
	
	}
	
	/**
	 * Este método recibe un usuario JSON y lo elimina de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restBaja")
	public void bajaUsuario(Usuario usuario) {
		usu.eliminarUsuario(usuario);
	}
	
	/**
	 * Este método recibe un usuario JSON y lo modifica de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restModificar")
	public void modificarUsuario(Usuario usuario) {
		usu.modificarUsuario(usuario);
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve el username de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDevuelveUsuarioUserName")
	public Usuario devuelveUsuarioPorUsername(String userName) {
		return usu.devolverUsuarioPorUsername(userName);
		
	}
	
	/**
	 * Este método recibe una lista de usuarios JSON y lo muestra de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	
	@PostMapping("/restListadoInicial")
	public List<Usuario> devuelveListadoInicialSencillo(int idUsuario) {
		return usu.devuelveListadoInicialSencillo(idUsuario);
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve el id de usuario de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveUsuarioUserName")
	public Usuario devuelveUsuarioPorId(int id) {
		return usu.devuelveUsuarioId(id);
		
	}
		
}