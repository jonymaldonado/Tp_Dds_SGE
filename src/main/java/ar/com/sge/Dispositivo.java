package ar.com.sge;

public class Dispositivo {

	private String nombre;
	private Boolean encendido = false;
	private int kwPorHora;
	private float kwConsumido = 0;	
	
	public Dispositivo(String _nombre, int _kwPorHora) {		
		this.nombre = _nombre;
		this.kwPorHora = _kwPorHora;
	}
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return nombre;
	}	
	public void encender(){
		this.encendido = true;
	}
	public void apagar() {
		this.encendido = false;
    }
	public Boolean getEncendido(){
		return encendido;
	}
	public void tiempoDeCarga(int _tiempo) {
		this.kwConsumido += (kwPorHora/60) * _tiempo;
	}
	public float getKwConsumido() {
		return kwConsumido;
	}
	
}
