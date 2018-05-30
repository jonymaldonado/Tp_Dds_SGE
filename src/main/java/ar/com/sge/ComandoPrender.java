package ar.com.sge;

public class ComandoPrender implements Comando{
	private AdapterPrender adaptador;
	private String nombrecomando;
	private DispositivoInteligente dispositivo;
	
	public void ejecutar() {
		dispositivo.encender();
	}

	public AdapterPrender getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(AdapterPrender adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombrecomando;
	}

	public void setNombrecomando(String nombrecomando) {
		this.nombrecomando = nombrecomando;
	}

}
