package ar.com.sge;

public class AdapterEncender implements Adapter {
	
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.encender();
	}
}
