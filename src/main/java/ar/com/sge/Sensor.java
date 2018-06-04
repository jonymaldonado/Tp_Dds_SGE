package ar.com.sge;

import java.util.List;

public class Sensor {
	
	private List<Regla> observadores;
	
	public Sensor() {
		
	}

	public void agregarObservador(Regla regla){
		observadores.add(regla);
	}
	
	public void eliminarObservador(Regla regla) {
		observadores.remove(regla);
	}
	
	public void setValor(float valor) {
		observadores.forEach(o -> o.notificar(valor));
	}
}











