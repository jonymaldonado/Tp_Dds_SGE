package ar.com.sge;

public class ComandoPrender implements Comando{
	private Adapter adaptador;
	private String nombrecomando;
	private DispositivoInteligente dispositivo;
	
	public void ejecutar() {
		dispositivo.encender();
	}

	public Adapter getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(Adapter adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombrecomando;
	}

	public void setNombrecomando(String nombrecomando) {
		this.nombrecomando = nombrecomando;
	}

}
