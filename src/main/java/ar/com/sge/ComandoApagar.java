package ar.com.sge;

public class ComandoApagar implements Comando{
	
	private DispositivoInteligente dispositivo;
	private String nombreComando;
	
	public ComandoApagar() {
		this.nombreComando = "apagar";
	}
	
	public void ejecutar() {
		dispositivo.apagar();
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
