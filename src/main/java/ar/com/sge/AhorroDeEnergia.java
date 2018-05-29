package ar.com.sge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AhorroDeEnergia extends Estado {
	
	public AhorroDeEnergia(DispositivoInteligente d) {
		super(d);
		this.nombre = "modo ahorro";
		fechaInicio = LocalDateTime.now();
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
