package ar.com.sge;

public class AdapterApagar implements Adapter {
	
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.apagar();
	}
}
