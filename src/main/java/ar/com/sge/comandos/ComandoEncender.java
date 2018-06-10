package ar.com.sge.comandos;

import ar.com.sge.dispositivos.DispositivoInteligente;

public class ComandoEncender implements Comando{
	
	private AdapterEncender adaptador;
	private String nombreComando;
	private DispositivoInteligente dispositivo;
	
	public ComandoEncender(AdapterEncender adaptador, String nombreComando, DispositivoInteligente dispositivo) {
		super();
		this.adaptador = adaptador;
		this.nombreComando = nombreComando;
		this.dispositivo = dispositivo;
	}

	public void ejecutar() {
		dispositivo.encender();
	}

	public AdapterEncender getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterEncender adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombreComando;
	}

	public void setNombrecomando(String nombrecomando) {
		this.nombreComando = nombrecomando;
	}

}
