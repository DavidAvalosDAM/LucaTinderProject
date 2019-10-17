package com.lucatinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucatinder.model.Usuario;
import com.lucatinder.pruebaunitaria.dao.IPersonaRepo;

@Controller
public class PruebaControlador {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/")
	public String base(Model model) {
		
		//ya... ya se que no es un bean, pero por favor déjame vivir que estoy CONTENTO!!!
		Usuario p=new Usuario();
		p.setNombre("Rosssio");
		repo.save(p);
		
		model.addAttribute("persona",p);
		
		return "prueba";
	}
	
	@GetMapping("/tabla")
	public String tabla(Model model) {
		
		
		model.addAttribute("personas",repo.findAll());
		
		return "tabla";
	}
}
