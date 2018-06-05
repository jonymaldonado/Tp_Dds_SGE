package ar.com.sge;

public class ComandoEncender implements Comando {

	private String nombreComando;
	private DispositivoInteligente dispositivo;
	
	public ComandoEncender() {
		this.nombreComando = "encender";
	}
	
	public void ejecutar() {
		dispositivo.encender();
	}

	public DispositiviInteligene getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente disp) {
		this.dispositivo = disp;
	}

	public String getNombreComando() {
		return nombreComando;
	}
}
