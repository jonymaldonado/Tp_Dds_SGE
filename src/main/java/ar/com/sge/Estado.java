package ar.com.sge;
import java.time.LocalDate;

public abstract class Estado {
	

	private DispositivoInteligente dispo;
	protected LocalDate fecha_inicio;
	protected LocalDate fecha_fin;
	protected float consumo;
	protected String nombre;
	
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
		return fecha_inicio;
	}


	public void setInicio(LocalDate inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public LocalDate getFin() {
		return fecha_fin;
	}


	public void setFin(LocalDate fin) {
		this.fecha_fin = fecha_fin;
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
