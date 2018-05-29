package ar.com.sge;

public class comandoprender implements comando{
	private Adapter adaptador;
	private String nombrecomando;
	
	public void ejecutar() {
		//adaptador.prendete();
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
