package ar.com.sge;

public class AdapterApagar implements Comando {

	private Fabricante fabricante;
	private String nombre;
	
	@Override
	public void ejecutar() {
		fabricante.apagar();
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
