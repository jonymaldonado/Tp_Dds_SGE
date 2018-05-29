package ar.com.sge;

public class DispositivoEstandar {
	
	private String nombre;
	protected float kwPorHora;
	private int horasDeUso;
	
	public DispositivoEstandar(String nombre, float kw, int hs) {
		this.nombre = nombre;
		this.kwPorHora = kw;
		this.horasDeUso = hs;
	}
	
	public String getNombre() {
		return nombre;
	}
		
	public float getKwPorHora() {
		return kwPorHora;
	}
	
	public void setHorasDeUso(int hr) {
		this.horasDeUso = hr;
	}
	
	public int getHorasDeUso() {
		return horasDeUso;
	}

	public float consumoEnKw() {
		return horasDeUso * this.getKwPorHora();
	}
	
}