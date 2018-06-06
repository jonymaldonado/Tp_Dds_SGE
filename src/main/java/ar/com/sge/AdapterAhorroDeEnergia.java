package ar.com.sge;

public class AdapterAhorroDeEnergia implements Comando {

	private Fabricante fabricante;
	private String nombre;
	
	@Override
	public void ejecutar() {
		fabricante.ahorroDeEnergia();
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante1) {
		this.fabricante = fabricante1;
	}
	
	public String getNombre() {
		return nombre;
	}
}
