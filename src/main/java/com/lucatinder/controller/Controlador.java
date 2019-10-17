package com.lucatinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucatinder.dao.IPersonaRepo;
import com.lucatinder.model.Persona;

@Controller
public class Controlador {
	
	@Autowired
	private IUsuario dao;
	
	@GetMapping("/")
	public String  urlLogin(Usuario u, Model model) {
		dao.save(u);
		model.addAttribute("usuario",u);
		return "index";
	}
	
	/*Es necesario para que el formulario funcione.
	 * @GetMapping("/form")
    public String showUserForm(Model model) throws Exception{
		Persona p=new Persona();
        model.addAttribute("persona", p);
        return "formulario";
    
	}*/
}
