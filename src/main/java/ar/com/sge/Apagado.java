package ar.com.sge;

import java.time.LocalDateTime;

public class Apagado extends Estado{

	public Apagado(DispositivoInteligente d) {
		super(d);
		this.nombre = "apagado";
		fechaInicio =LocalDateTime.now();
	}
	
	public void encender() {
		fechaFin = LocalDateTime.now();
		consumo = 0;
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido(dispositivo));			
	}

	public void apagar() {
		
	}

	public void ahorroDeEnergia() {

	}
}
