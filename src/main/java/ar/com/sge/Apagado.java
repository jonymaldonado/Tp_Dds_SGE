package ar.com.sge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Apagado extends Estado{

	public Apagado(DispositivoInteligente d) {
		super(d);
		this.nombre = "apagado";
		fechaInicio =LocalDateTime.now();
	}
	
	public void encender() {
		fechaFin = LocalDateTime.now();
		float tiempo = ChronoUnit.HOURS.between(fechaInicio,fechaFin);
		consumo = tiempo * dispositivo.getKwPorHora();
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido(dispositivo));			
	}

	public void apagar() {
		
	}

	public void ahorroDeEnergia() {

	}
}
