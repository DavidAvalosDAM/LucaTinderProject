package com.lucatinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucatinder.dao.IUsuarioDao;
import com.lucatinder.model.Usuario;

@Controller
public class Controlador {
	
	@Autowired
	private IUsuarioDao dao;
	
	@GetMapping("/")
	public String  urlLogin(Model model) {
				
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("status","");
		return "login";
	}
	
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
	
	/*Es necesario para que el formulario funcione.
	 * @GetMapping("/form")
    public String showUserForm(Model model) throws Exception{
		Persona p=new Persona();
        model.addAttribute("persona", p);
        return "formulario";
    
	}*/
}
