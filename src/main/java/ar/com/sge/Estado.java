package ar.com.sge;
import java.time.LocalDate;

public abstract class Estado {
	

	private DispositivoInteligente dispo;
	private LocalDate inicio;
	private LocalDate fin;
	private float consumo;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Estado(DispositivoInteligente unDispositivo) {
		// TODO Auto-generated constructor stub
	}
	

	public DispositivoInteligente getDispo() {
		return dispo;
	}



	public void setDispo(DispositivoInteligente dispo) {
		this.dispo = dispo;
	}




	public LocalDate getInicio() {
		return inicio;
	}


	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}


	public LocalDate getFin() {
		return fin;
	}


	public void setFin(LocalDate fin) {
		this.fin = fin;
	}


	public float getConsumo() {
		return consumo;
	}


	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}


	public abstract void encender();
	public abstract void apagar();
	public abstract void ahorroDeEnergia();
}
