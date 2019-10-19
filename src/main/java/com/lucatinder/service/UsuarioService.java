package com.lucatinder.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.lucatinder.model.Usuario;
import com.varo.spring.model.Kitty;

public interface UsuarioService {

	public void guardarUsuario(Usuario u);

	public void eliminarUsuario(Usuario u);

	public void modificarUsuario(Usuario u);
    
	public List<Usuario> list();
	
}
