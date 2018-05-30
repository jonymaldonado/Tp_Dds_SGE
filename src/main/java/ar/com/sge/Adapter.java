package ar.com.sge;

public class AdapterPrender implements comandoprender {
	private Fabricante fabricante
	
	public void AdapterPrender() {
		fabricante = new Fabricante();
	}
	
	@override
	public void ejecutar() {
		fabricante.prendete()
	}
}
