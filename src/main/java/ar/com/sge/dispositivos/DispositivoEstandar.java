package ar.com.sge.dispositivos;

public class DispositivoEstandar implements IDispositivo{
	
	private String nombre;
	protected float kwPorHora;
	private int horasDeUso;
	
	public DispositivoEstandar(String nombre, float kw, int hs) {
		this.nombre = nombre;
		this.kwPorHora = kw;
		this.horasDeUso = hs;
	}
	
	@Override
	public IDispositivo clone() throws CloneNotSupportedException{
		DispositivoInteligente inteligente=null;
		try {
			inteligente=(DispositivoInteligente) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return inteligente;
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