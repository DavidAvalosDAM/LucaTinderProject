package com.lucatinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue
	@Column(name = "idusuario")
	private int idPersona;
	
	@Column(name="nombrepersona", length = 45)
	private String nombre;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
