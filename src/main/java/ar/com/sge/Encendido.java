package ar.com.sge;

import java.time.LocalDate;


public class Encendido extends Estado{
	
	public Encendido(DispositivoInteligente unDispositivo) {
		super(unDispositivo);
		this.nombre = "encendido";
		this.fecha_inicio = LocalDate.now();
	}

	
	public void encender(DispositivoInteligente unDispositivo) {
		// TODO Auto-generated method stub
		
	}


	public void apagar(DispositivoInteligente unDispositivo) {
		this.fecha_fin = LocalDate.now();
	//	tiempoConsumido = tiempoEnMinutos(fecha_inicio,fecha_fin);
		unDispositivo.agregarAListaDeEstados(this);
		unDispositivo.setEstado(new Apagado(unDispositivo));
	}

	
	public void ahorroDeEnergia() {
		// TODO Auto-generated method stub
		
	}

}
