package ar.com.sge;

public class ComandoApagar implements Comando{
	
	private AdapterApagar adaptador;
	private String nombreComando;
	
	public ComandoApagar() {
		this.nombreComando = "apagar";
	}
	
	public void ejecutar(DispositivoInteligente dispositivo) {
		adaptador.ejecutar(dispositivo);
	}

	public AdapterApagar getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterApagar adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombreComando() {
		return nombreComando;
	}
}
