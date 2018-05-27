package ar.com.sge;

public class DispositivoEstandar {

	private String nombre;
	private float kwPorHora = 0;
	private float horasConsumidas = 0;	
	
	public DispositivoEstandar(String unNombre, int unakwPorHora) {		
		this.nombre = unNombre;
		this.kwPorHora = unakwPorHora;
	}
	
	// Getter and Setters
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return nombre;
	}
	public float getKwPorHora() {
		return kwPorHora;
	}
	public void setKwPorHora(float kwPorHora) {
		this.kwPorHora = kwPorHora;
	}
	public float getHorasConsumidas() {
		return horasConsumidas;
	}
	public void setHorasConsumidas(int horasCosumidas) {
		this.horasConsumidas = horasCosumidas;
	}
	
	// Calculo de consumo
	public float consumoEnKw() {
		return this.horasConsumidas *  this.kwPorHora;
	}
	
}
