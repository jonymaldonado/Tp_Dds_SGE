package ar.com.sge;
import java.time.LocalDateTime;

public abstract class Estado {
	

	private DispositivoInteligente dispo;
	protected LocalDateTime fecha_inicio;
	protected LocalDateTime fecha_fin;
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




	public LocalDateTime getInicio() {
		return fecha_inicio;
	}


	public void setInicio(LocalDateTime inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public LocalDateTime getFin() {
		return fecha_fin;
	}


	public void setFin(LocalDateTime fin) {
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
