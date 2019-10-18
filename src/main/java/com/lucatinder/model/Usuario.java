package com.lucatinder.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * @autor Yolanda
 * Creamos modelo tabla
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "idUsuario")
	private int idUsuario;

	private String nombre;

	private String password;

	private String genero;

	private int edad;

	@Column(length = 200)
	private String descripcion;
	
	private ArrayList gustosinformaticos;

	// Se crea el constructor vacio por defecto//
	public Usuario() {

	}
	
	// Se rellena el constructor con los todos los atributos.
	public Usuario(int idUsuario, String nombre, String password, String genero, int edad, String descripcion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;

	}

	// Se crean metodos Setters/Getters

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList getGustosinformaticos() {
		return gustosinformaticos;
	}

	public void setGustosinformaticos(ArrayList gustosinformaticos) {
		this.gustosinformaticos = gustosinformaticos;
	}
    
			
	}
