package ar.com.sge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Encendido extends Estado {

	
	public Encendido(DispositivoInteligente d) {
		super(d);
		this.nombre = "encendido";
		fechaInicio = LocalDateTime.now();	
	}
	
	public void encender() {
		
	}

	public void apagar() {		
		fechaFin = LocalDateTime.now();
		float tiempo= ChronoUnit.HOURS.between(fechaInicio,fechaFin);
		consumo = tiempo * dispositivo.getKwPorHora();
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Apagado(dispositivo));
	}

	public void ahorroDeEnergia() {
		dispositivo.setEstado(new AhorroDeEnergia(dispositivo));
	}
}
