 package ar.com.sge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class DispositivoInteligente {

	private Estado estado;
	private String nombre;
	private int kwPorHora;
	private float kwConsumido = 0;
	private List<Estado> listaDeEstados;
	private static final double coeficienteAhorroEnergia = 0.6 ;
	
	public DispositivoInteligente(String unNombre, int unKwPorHora) {		
		this.nombre = unNombre;
		this.kwPorHora = unKwPorHora;
	}
	
	// Getter and Setters
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	public String getNombre() {
		return nombre;
	}	
	public Estado getEstado() {
		return estado;
	}	
	public void setEstado(Estado estado) {
 		this.estado = estado;
	}
	public int getKwPorHora() {
		return kwPorHora;
	}

	public void setKwPorHora(int kwPorHora) {
		this.kwPorHora = kwPorHora;
	}

	// Cambios de estados
	public void encender(){
		this.estado.encender();
	}
	public void apagar() {
		this.estado.apagar();
    }	
	public void ahorroDeEnergia() {
		this.estado.ahorroDeEnergia();
    }
	
	// Saber estado
	public Boolean estasEncendido() {
		return this.estado.getNombre().equals("Encendido");
	}
	public Boolean estasApagado() {
		return this.estado.getNombre().equals("Apagado");
	}
	public float getKwConsumido() {
		return kwConsumido;
	}
	
	// Calculo de consumos
	
	public float consumidoUltimasNhoras (int cantHoras) {
		LocalDateTime fechaInicio = LocalDateTime.now().minusHours(cantHoras);
		LocalDateTime fechaFin = LocalDateTime.now();
		return this.consumidoEntre(fechaInicio, fechaFin);
	}
	public float consumidoEntre(LocalDateTime fechaInicio , LocalDateTime fechaFin) {
		float totalHoras = 0;
		float totalConsumo = 0;
		List<Estado> lstEstados;
		
		//Calculo consumo encendidos 		
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Encendido");
		totalHoras = this.totalDeHoras(lstEstados);
		totalConsumo = totalHoras * this.getKwPorHora();
		
		//Calculo consumo ahorro de energia
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Ahorro de enegia");
		totalHoras = this.totalDeHoras(lstEstados);
		totalConsumo += totalHoras * this.getKwPorHora() * DispositivoInteligente.coeficienteAhorroEnergia;
		
		return totalConsumo;
	}
	
	public List<Estado> listaDeEstadosSegun (LocalDateTime fechaInicio , LocalDateTime fechaFin, String tipoDeEstado) {
		List<Estado> lstEstadosSegun;
		lstEstadosSegun = 
				(List<Estado>) this.listaDeEstados.stream().filter(e -> e.getInicio().isAfter(fechaInicio) 
						&& e.getFin().isBefore(fechaFin)
						&& e.getNombre().equals(tipoDeEstado));
		return lstEstadosSegun;
		 
	}
	public float totalDeHoras (List<Estado> lstEstados) {		
		float totalHoras = 0;		
		for (Estado estado : lstEstados){
			totalHoras += diferenciaHoras(estado.getInicio(),estado.getFin());
		}
		return totalHoras;
	}
	
	public static int diferenciaHoras(LocalDateTime unahora, LocalDateTime otrahora){
		int dif= (int) ChronoUnit.HOURS.between(unahora, otrahora);
		return dif;
	}
	
	
	//VA?????
	
	public void agregarAListaDeEstados(Estado unEstado) {
		this.listaDeEstados.add(unEstado);
	}
	
}
