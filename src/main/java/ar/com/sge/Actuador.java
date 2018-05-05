package ar.com.sge;

public class Actuador {
	private String estado;
	
	
	public void encender(Dispositivo unDispositivo);
	public void apagar(Dispositivo unDispositivo);
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
