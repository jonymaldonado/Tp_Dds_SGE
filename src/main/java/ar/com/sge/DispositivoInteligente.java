package ar.com.sge;

public class DispositivoInteligente {

	private Estado estado;
	private String nombre;
	private int kwPorHora;
	private float kwConsumido = 0;	
	
	public DispositivoInteligente(String unNombre, int unKwPorHora) {		
		this.nombre = unNombre;
		this.kwPorHora = unKwPorHora;
	}
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return nombre;
	}	
	public void encender(){
		this.estado.encender();
	}
	public void apagar() {
		this.estado.apagar();
    }
	public void ahorroDeEnergia() {
		this.estado.ahorroDeEnergia();
    }	
	public Boolean estasEncendido() {
		return this.estado.getNombre().equals("Encendido");
	}
	public Boolean estasApagado() {
		return this.estado.getNombre().equals("Apagado");
	}
	public void tiempoDeCarga(int _tiempo) {
		this.kwConsumido += (kwPorHora/60) * _tiempo;
	}
	public float getKwConsumido() {
		return kwConsumido;
	}
	
}
