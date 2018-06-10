package ar.com.sge.usuarios;

import java.time.LocalDate;
import java.time.Period;

public class Administrador extends Usuario{

	private int numeroId;
	
	
	public Administrador(String _nombre, String _apellido, int _numeroId) {
		super(_nombre,_apellido);
		this.numeroId = _numeroId;
	}
	public int getNumeroId() {
		return numeroId;
	}
	public void tiempoEnElCargo() {
		LocalDate ini = getAlta();
		LocalDate fin = LocalDate.now();
		int days = Period.between(ini,fin).getDays();
		int months = Period.between(ini,fin).getMonths();
		int years = Period.between(ini,fin).getYears();
		System.out.println(years+" a�o, "+ months +" meses, "+days+" dias");
	}
}
 