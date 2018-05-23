package ar.com.sge;

public class TV extends DispositivoInteligente {
	private int volumen;
	private int reloj;
	
	public TV(String _nombre, int _kwPorHora) {
		super(_nombre, _kwPorHora);
		// TODO Auto-generated constructor stub
		this.volumen=0;
	}//fin constructor
	
	
	public void subirVolumen() {
		this.volumen=+1;
	}// fin subirVolumen
	
	public void bajarVolumen() {
		this.volumen=-1;
	}// fin bajarVolumen


//	public int getVolumen() {
//		return volumen;
//	}// fin getVolumen


//	public void setVolumen(int volumen) {
//		this.volumen = volumen;
//	}// fin setVolumen


	public int getReloj() {
		return reloj;
	}// fin getReloj


	public void setReloj(int reloj) {
		this.reloj = reloj;
	}// fin setReloj
	

}//fin TV
