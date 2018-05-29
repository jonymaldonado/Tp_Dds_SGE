package ar.com.sge;

public class comandoprender implements comando{
	private adapter adaptador;
	private String nombrecomando;
	
	public void ejecutar() {
		adaptador.prendete();
	}

	public adapter getAdaptador() {
		return adaptador;
	}

	public void setAdaptador(adapter adaptador) {
		this.adaptador = adaptador;
	}

	public String getNombre() {
		return nombrecomando;
	}

	public void setNombrecomando(String nombrecomando) {
		this.nombrecomando = nombrecomando;
	}

}
