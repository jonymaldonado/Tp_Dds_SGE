package ar.com.sge;

import java.time.LocalDate;

public abstract class Usuario {
	private String nombre_usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String domicilio;
	private LocalDate alta;
	
	public Usuario(String _nombre,String _apellido) {
		this.nombre = _nombre;
		this.apellido = _apellido;
		//this.alta = LocalDate.now();
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public LocalDate getAlta() {
        return alta;
	}
	
	public String getNombreUsuario() {
		return nombre_usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	
	
}
