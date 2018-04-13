package ar.com.sge;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Usuario {

	private String nombre;
	private String apellido;
	private String domicilio;
	private Date alta;
	
	public Usuario(String _nombre,String _apellido) {
		this.nombre = _nombre;
		this.apellido = _apellido;
		this.alta = new Date();
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
	public String getAlta() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(alta);
	}
}
