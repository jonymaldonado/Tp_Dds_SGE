package ar.com.sge;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Encendido extends Estado{
	
	public Encendido(DispositivoInteligente unDispositivo) {
		super(unDispositivo);
		this.nombre = "encendido";
		this.fecha_inicio = LocalDateTime.now();
	}

	
	public void encender() {
		// TODO Auto-generated method stub
		
	}


	public void apagar() {
		this.fecha_fin = LocalDateTime.now();
	//	tiempoConsumido = tiempoEnMinutos(fecha_inicio,fecha_fin);
		this.getDispo().agregarAListaDeEstados(this);
		this.getDispo().setEstado(new Apagado(this.getDispo()));
	}

	
	public void ahorroDeEnergia() {
		// TODO Auto-generated method stub
		
	}

}
