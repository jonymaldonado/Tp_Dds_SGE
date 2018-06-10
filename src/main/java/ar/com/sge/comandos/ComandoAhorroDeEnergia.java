package ar.com.sge.comandos;

import ar.com.sge.dispositivos.DispositivoInteligente;

public class ComandoAhorroDeEnergia implements Comando {
	private AdapterAhorroDeEnergia adaptador;
	private String nombreComando;
	private DispositivoInteligente dispositivo;
	
	
	
	public ComandoAhorroDeEnergia(AdapterAhorroDeEnergia adaptador, String nombreComando, DispositivoInteligente dispositivo) {
		super();
		this.adaptador = adaptador;
		this.nombreComando = nombreComando;
		this.dispositivo = dispositivo;
	}

	public void ejecutar() {
		dispositivo.ahorroDeEnergia();
	}

	public AdapterAhorroDeEnergia getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterAhorroDeEnergia adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombreComando;
	}

	public void setNombreComando(String nombrecomando) {
		this.nombreComando = nombrecomando;
	}
}
