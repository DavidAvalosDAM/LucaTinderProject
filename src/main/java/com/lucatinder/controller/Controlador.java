package com.lucatinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;
import com.lucatinder.service.UsuarioService;
import com.lucatinder.service.UsuarioServiceImpl;

@Controller
/**
 * @author Iván
 *En esta clase se realizaran todas las operaciones de control.
 */
public class Controlador {
	
	@Autowired
	private IUsuarioDao dao;
	
	@Autowired
	private UsuarioService usi;
	
	/**
	 *@author Iván 
	 *Método para entrar en login.
	 */
	@GetMapping("/")
	public String  urlLogin(Model model) {		
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("status","");
		return "login";
	}
	
	/**
	 * @author Iván
	 * Metodo para comprobar usuario y contraseña.
	 */
	@PostMapping("/")
	public String  urlLoginEnviado(Usuario u,Model model) {	
		if (u.getPassword().equals(dao.buscaPorNombre(u.getNombre()).getPassword())){
			model.addAttribute("usuario",u);
			return "index";
		}
		else {
			model.addAttribute("usuario",new Usuario());
			model.addAttribute("status","El usuario o la contraseña son incorrectos");
			return "login";
		}	
	}
	
	/**
	 * @author Iván
	 * Los siguientes 2 métodos sirven para en caso de no estar registrado te puedas registrar (guardar usuario).
	 */
	@GetMapping("/alta")
	public String urlAlta(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formularioAlta";
	}
	
	@PostMapping("/alta")
	public String urlAltaRecibido(Model model, Usuario u) {
		usi.guardarUsuario(u);
		return "formularioAlta";
	}
}
