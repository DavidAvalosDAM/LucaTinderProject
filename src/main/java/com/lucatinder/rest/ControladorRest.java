package com.lucatinder.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.model.Contactos;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.ContactoService;
import com.lucatinder.service.DescartesService;
import com.lucatinder.service.MatchesService;
import com.lucatinder.service.UsuarioService;

@RestController

public class ControladorRest {
	
	private Usuario usuarioPadre;
	@Autowired
	private UsuarioService usu;
	
	@Autowired
	private ContactoService cs;
	
	@Autowired
	private DescartesService ds;
	
	@Autowired
	private MatchesService ms;
	
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
	 * @date 23/10/2019
	 */
	@PostMapping("/restBaja")
	public void bajaUsuario(@RequestBody Usuario usuario) {
		usu.eliminarUsuario(usuario);
	}
	
	/**
	 * Este método recibe un usuario JSON y lo modifica de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restModificar")
	public void modificarUsuario(@RequestBody Usuario usuario) {
		usu.modificarUsuario(usuario);
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve el username de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveUsuarioUserName")
	public Usuario devuelveUsuarioPorUsername(@RequestBody String userName) {
		return usu.devolverUsuarioPorUsername(userName);
		
	}
	
	/**
	 * Este método recibe una lista de usuarios JSON y lo muestra de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	
	/*@GetMapping("/restListadoInicial")
	public List<Usuario> devuelveListadoInicialSencillo(@RequestBody int idUsuario) {
		return usu.devuelveListadoInicialSencillo(idUsuario);
	}*/
	
	/**
	 * Este método recibe un usuario JSON y devuelve el id de usuario de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveUsuarioUserName")
	public Usuario devuelveUsuarioPorId(@RequestBody int id) {
		return usu.devuelveUsuarioId(id);
		
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Contactos de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveListadoContactos")
	public List<Usuario> devuelveListadoContactos(@RequestBody int idUsuarioContactante) {
		return cs.devuelveListaContactos(idUsuarioContactante);
		
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Descartes de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveListaDescartes")
	public List<Usuario> devuelveListaDescartes(@RequestBody int idUsuarioDescartante) {
		return ds.devuelveListaDescartes(idUsuarioDescartante);
		
	}
	
	/**
	 * Este método recibe un usuario JSON y devuelve la lista de Matches de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveListaMatches")
	public List<Usuario> devuelveListaMatches(@RequestBody int idUsuarioSolicitante) {
		return ms.devuelveMatches(idUsuarioSolicitante);
		
	}
	
	/**
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restContactar")
	public void contactar(@RequestBody Usuario u){
		Contactos c = new Contactos();
		c.setUsuarioContactante(usuarioPadre);
		c.setUsuarioContactado(u);
		cs.contactar(c);
	
	}
	
	/**
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restDescartar")
	public void descartar(@RequestBody Usuario u){
		Descartes d = new Descartes();
		d.setUsuarioDescartante(usuarioPadre);
		d.setUsuarioDescartado(u);
		ds.addDescarte(d);
	
	}
		
}