package com.lucatinder.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Creamos clase Usuario.
 * 
 * @autor Yolanda
 * 
 **/
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "idUsuario")
	private int idUsuario;

	@Column(name = "username", unique = true, nullable = false, length = 40)
	private String username;

	@Column(name = "name", nullable = false, length = 40)
	private String name;

	@Column(name = "password", nullable = false, length = 40)
	private String password;

	@Column(name = "genero", nullable = false, length = 3)
	private String genero;

	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "descripcion", nullable = true, length = 200)
	private String descripcion;

	/*@Column(name = "gustosinformaticos", nullable = true)
	private ArrayList gustosinformaticos=new ArrayList<>();*/

	/**
	 * Se crea el constructor vacio por defecto//
	 */
	public Usuario() {

	}

	/**
	 * Se rellena el constructor con los todos los atributos menos gustos
	 * informáticos(opcional).
	 */
	public Usuario(int idUsuario, String username, String nombre, String password, String genero, int edad,
			String descripcion) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.name = name;
		this.password = password;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;

	}

	/**
	 * Se crean metodos Setters/Getters y toString
	 * 
	 */

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", name=" + name + ", password="
				+ password + ", genero=" + genero + ", edad=" + edad + ", descripcion=" + descripcion
				+ ", gustosinformaticos=" + "]";
	}

	
}
