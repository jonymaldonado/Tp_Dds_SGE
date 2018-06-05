package ar.com.sge;

public class AdapterApagar implements ComandoApagar {
	
	private Fabricante fabricante;
	
	@override
	public void ejecutar() {
		fabricante.apagar();
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante1) {
		this.fabricante = fabricante1
	}
}
