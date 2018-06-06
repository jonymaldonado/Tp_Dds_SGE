package ar.com.sge;

public class ComandoApagar implements Comando {

	private AdapterApagar adaptador;
	private String nombreComando;
	private DispositivoInteligente dispositivo;
	
	public void ejecutar() {
		dispositivo.apagar();
	}

	public AdapterApagar getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterApagar adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombreComando;
	}

	public void setNombreComando(String nombrecomando) {
		this.nombreComando = nombrecomando;
	}
}
