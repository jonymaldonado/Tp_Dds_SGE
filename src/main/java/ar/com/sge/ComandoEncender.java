package ar.com.sge;

public class ComandoEncender implements Comando{
	
	private AdapterEncender adaptador;
	private String nombreComando;
	private DispositivoInteligente dispositivo;
	
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
