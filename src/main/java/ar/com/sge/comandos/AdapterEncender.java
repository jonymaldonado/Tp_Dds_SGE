package ar.com.sge.comandos;

public class AdapterEncender implements Comando {
	
	private Fabricante fabricante;
	private String nombre;
	
	@Override
	public void ejecutar() {
		fabricante.encender();
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
