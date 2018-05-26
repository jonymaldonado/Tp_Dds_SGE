package ar.com.sge;

import java.util.ArrayList;

public class DispositivoInteligente {

	private Estado estado;
	private String nombre;
	private int kwPorHora;
	private float kwConsumido = 0;
	private ArrayList<Estado> listaDeEstados;
	
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
	
	public Estado getEstado() {
		return estado;
	}
	// Lo agrego por si se quiere poner une estado al dispositivo al inciar
	public void setEstado(Estado estado) {
 		this.estado = estado;
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
	
	public void agregarAListaDeEstados(Estado unEstado) {
		this.listaDeEstados.add(unEstado);
	}
	
}
