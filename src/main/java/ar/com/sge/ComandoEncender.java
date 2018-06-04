package ar.com.sge;

public class ComandoEncender implements Comando {

	private AdapterEncender adaptador;
	private String nombreComando;
	
	public ComandoEncender() {
		this.nombreComando = "encender";
	}
	
	public void ejecutar(DispositivoInteligente dispositivo) {
		adaptador.ejecutar(dispositivo);
	}

	public AdapterEncender getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterEncender adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombreComando() {
		return nombreComando;
	}
}
