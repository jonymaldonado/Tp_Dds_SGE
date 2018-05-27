 package ar.com.sge;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class DispositivoInteligente {

	private Estado estado;
	private String nombre;
	private int kwPorHora;
	private float kwConsumido = 0;
	private List<Estado> listaDeEstados;
	
	public DispositivoInteligente(String unNombre, int unKwPorHora) {		
		this.nombre = unNombre;
		this.kwPorHora = unKwPorHora;
	}
	
	// Getter and Setters
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return nombre;
	}	
	public Estado getEstado() {
		return estado;
	}	
	public void setEstado(Estado estado) {
 		this.estado = estado;
	}
	
	// Cambios de estados
	public void encender(){
		this.estado.encender();
	}
	public void apagar() {
		this.estado.apagar();
    }	
	public void ahorroDeEnergia() {
		this.estado.ahorroDeEnergia();
    }
	
	// Saber estado
	public Boolean estasEncendido() {
		return this.estado.getNombre().equals("Encendido");
	}
	public Boolean estasApagado() {
		return this.estado.getNombre().equals("Apagado");
	}
	public float getKwConsumido() {
		return kwConsumido;
	}
	
	// Calculo de consumos
	public void tiempoDeCarga(int _tiempo) {
		this.kwConsumido += (kwPorHora/60) * _tiempo;
	}
	public void consumidoUltimasNhoras (int cantHoras) {
		LocalDateTime fecha = LocalDateTime.now().minusHours(cantHoras);	
	}
	public float consumidoEntre (LocalDateTime fechaInicio , LocalDateTime fechaFin) {
		List<Estado> lstEstadosEntre;
		lstEstadosEntre = 
				(List<Estado>) this.listaDeEstados.stream().filter(e -> e.getInicio().isAfter(fechaInicio) && e.getFin().isBefore(fechaFin));
		return this.consumoTotal(lstEstadosEntre);
		 
	}
	public float consumoTotal (List<Estado> lstEstados) {		
		float consumoTotalestados = 0;		
		for (Estado estado : lstEstados){
			consumoTotalestados += estado.getConsumo();
		}
		return consumoTotalestados;
	}
	
	//VA?????
	
	public void agregarAListaDeEstados(Estado unEstado) {
		this.listaDeEstados.add(unEstado);
	}
	
}
