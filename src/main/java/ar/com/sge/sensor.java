package ar.com.sge;

import java.util.List;

public class sensor {
	private regla regla;
	
	
	public void realizarmedicion() {
		int medicion=0;
		regla.verificarregla(medicion);
		
	}
	

}
