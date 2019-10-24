package com.lucatinder.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Contactos;
import com.lucatinder.model.Descartes;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.ContactoService;
import com.lucatinder.service.DescartesService;
import com.lucatinder.service.MatchesService;
import com.lucatinder.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class ControladorRest {
	
	private Logger log=Logger.getLogger("Controlador Rest: -------");
	private Usuario usuarioPadre;
	@Autowired
	private UsuarioService usi;
	
	@Autowired
	private ContactoService cs;
	
	@Autowired
	private DescartesService ds;
	
	@Autowired
	private MatchesService ms;
	
	@Autowired
	private IUsuarioDao usuDao;
	
	
	@PostMapping("/restLogin")//FUNCIONA
	public Usuario urlLoginEnviado(@RequestBody Usuario u) {
		try {
			log.info("Recibiendo info de usuario para login");
			log.info("NOMBRE: "+u.getUsername());
			log.info(u.getPassword());

			Usuario usuarioComprobador = usi.devolverUsuarioPorUsername(u.getUsername());
			log.info("Usuario encontrado:");
			log.info(usuarioComprobador.getUsername());
			log.info(usuarioComprobador.getPassword());
			
		if (u.getPassword().equals(usuarioComprobador.getPassword())) {
			log.info("Password coincidente");
			log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"");
			usuarioPadre=usi.devolverUsuarioPorUsername(u.getUsername());
			
			return usuarioPadre;

		}else {
			log.info("Password no coincidente");
		
			return u;
		}
		}catch(Exception e) {
			log.info("El usuario no existe");
			return u;
		}
	}
	
	/**
	 * Este método recibe un usuario JSON y lo guarda en la BBDD.
	 * @author Yolanda
	 * @version 1.0
	 * @date 22/10/2019
	 */
	@PostMapping("/restAlta")//FUNCIONA
	public Usuario altaUsuario(@RequestBody Usuario u){
		try {
		
			usi.guardarUsuario(u);
			return usi.devolverUsuarioPorUsername(u.getUsername());
		}catch(Exception e){
			u.setIdUsuario(0);
			return u;
		}
	
	}
	
	/**
	 * Este método recibe un usuario JSON y lo elimina de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restBaja")//FUNCIONA
	public Usuario bajaUsuario(@RequestBody Usuario u) {
		
			log.info(u.getIdUsuario()+"");
			log.info(u.getUsername());
			
			if(usi.devolverUsuarioPorUsername(u.getUsername()).getUsername().equals(u.getUsername())){
				log.info("Username coincidente");
				usi.eliminarUsuario(usi.devolverUsuarioPorUsername(u.getUsername()));
				log.info("User borrado");
				u.setIdUsuario(1);
				return u;
			}else {
				log.info("User no coincide, peticion desechada");
				u.setIdUsuario(0);
				return u;
			}
		
	}
	
	/**
	 * Este método recibe un usuario JSON y lo modifica de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@PostMapping("/restModificar")
	public Usuario modificarUsuario(@RequestBody Usuario u) {
		
		usi.modificarUsuario(u);
		try {
			
			usi.modificarUsuario(u);
			return usi.devolverUsuarioPorUsername(u.getUsername());
		}catch(Exception e){
			u.setIdUsuario(0);
			return u;
		}
	}

	
	/**
	 * Este método recibe un usuario JSON y devuelve el username de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveUsuarioUserName")
	public Usuario devuelveUsuarioPorUsername(@RequestBody String userName) {
		return usi.devolverUsuarioPorUsername(userName);
		
	}
	
	/**
	 * Este método recibe una lista de usuarios JSON y lo muestra de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	
	@PostMapping("/restListadoInicial")//FUNCIONA
	public List<Usuario> devuelveListadoInicialComplejo(@RequestBody Usuario u) {
		return usi.devuelveListadoInicialComplejo(u.getIdUsuario());
	}

	/**
	 * Este método recibe un usuario JSON y devuelve el id de usuario de la BBDD.
	 * @author Iván
	 * @version 1.0
	 * @date 23/10/2019
	 */
	@GetMapping("/restDevuelveUsuarioId")
	public Usuario devuelveUsuarioPorId(@RequestBody int id) {
		return usi.devuelveUsuarioId(id);
		
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
	@GetMapping("/restTodos")
		public List<Usuario> dameTodos(){
			
		return usuDao.findAll();
	}
		
}