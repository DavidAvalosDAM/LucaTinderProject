package com.lucatinder.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.IContactoService;
import com.lucatinder.service.UsuarioService;

@Controller
/**
 * En esta clase se realizaran todas las operaciones de control.
 * 
 * @author Iván
 * @version 1.0
 * @date 18/10/2019
 */
public class Controlador {

	private Logger log=Logger.getLogger("Controlador: -------");
	@Autowired
	private IUsuarioDao dao;

	@Autowired
	private UsuarioService usi;
	
	@Autowired
	private IContactoService ics;

	/**
	 *
	 * Método para entrar en login.
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Ivan
	 *
	 */
	
	@GetMapping("/")
	public String urlLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("status", "");
		return "login";
	}

	/**
	 * Metodo para comprobar usuario y contraseña.
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Ivan & Jorge
	 */
	@PostMapping("/")
	public String urlLoginEnviado(Usuario u, Model model) {
		try {
			log.info("Recibiendo info de usuario para login");
			log.info(u.getUsername());
			log.info(u.getPassword());
			
			Usuario usuarioComprobador=usi.devolverUsuarioPorUsername(u.getUsername());
			log.info("Usuario encontrado:");
			log.info(usuarioComprobador.getUsername());
			log.info(usuarioComprobador.getPassword());
			
		if (u.getPassword().equals(usuarioComprobador.getPassword())) {
			log.info("Password coincidente");
			log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"Lo que queremos comprobar ahora debe ser 25");
			model.addAttribute("usuario", usi.devolverUsuarioPorUsername(u.getUsername()));
			model.addAttribute("listaInicial", usi.devuelveListadoInicialSencillo(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario()));
			return "index";
		}else {
			log.info("Password no coincidente");
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("status", "El usuario o la contraseña son incorrectos");
			return "login";
		}
		
		}catch(Exception e) {
			log.info("El usuario no existe");
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("status", "El usuario o la contraseña son incorrectos");
			return "login";
		}	
	}

	/**
	 * Los siguientes 2 métodos sirven para en caso de no estar registrado te puedas
	 * registrar (guardar usuario).
	 * 
	 * @version 1.0
	 * @date 18/10/2019
	 * @autor Iván
	 */
	@GetMapping("/alta")
	public String urlAlta(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formularioalta";
	}

	@PostMapping("/alta")
	public String urlAltaRecibido(Model model, Usuario u) {
		usi.guardarUsuario(u);
		log.info((usi.devolverUsuarioPorUsername(u.getUsername())).getIdUsuario()+"");
		model.addAttribute("listaInicial", usi.devuelveListadoInicialSencillo(usi.devolverUsuarioPorUsername(u.getUsername()).getIdUsuario()));
		return "index";
	}

	/**
	 * Método creado para mostrar en html los datos del usuario
	 * 
	 * @version 1.0
	 * @date 20/10/2019
	 * @autor Yolanda
	 */
	@PostMapping("/datos")
	public String urlMisDatos(Usuario u, Model model) {
		model.addAttribute("usuario", u);
		return "datos";
	}
	
	/**
	 * Método creado para mostrar los contactos a los que se le ha dado like
	 * 
	 * @version 1.0
	 * @param model
	 * @autor David
	 */
	@GetMapping("/contactos")
	public String urlContactos(int idUsuarioContactante, Model model) {
		model.addAttribute("listaContactos",ics.devuelveListaContactos(idUsuarioContactante));
		return "listadoContactos";
	}
     
	@PostMapping("/eliminar")
	public String urlEliminarUsuario(Usuario u,Model model) {
		usi.eliminarUsuario(u);
		return "login";
	}

	@PostMapping("/modificarDatos")
	public String urlModificarUsuario(Usuario u,Model model) {
		usi.guardarUsuario(u);
		model.addAttribute("usuario", u);
		return "index";
	}
}