package ar.com.sge;

public class AdapterEncender implements ComandoEncender {
	
	private Fabricante fabricante;
	
	@override
	public void ejecutar() {
		fabricante.encender();
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante1) {
		this.fabricante = fabricante1
	}
}
