package ar.com.sge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DispositivoInteligente{

	private String nombre;
	protected float kwPorHora;
	private Estado estado;
	private List<Estado> listaDeEstados = new ArrayList<Estado>();
	private static final double coeficienteAhorroEnergia = 0.6;
	private LocalDateTime inicioPeriodo;

	public DispositivoInteligente(String nombre, float kw) {
		this.nombre = nombre;
		this.kwPorHora = kw;
	}

	public String getNombre() {
		return nombre;
	}
		
	public float getKwPorHora() {
		return kwPorHora;
	}
	
	public void setEstado(Estado e) {
		this.estado = e;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void encender() {
		estado.encender();
	}

	public void apagar() {
		estado.apagar();
	}

	public void ahorroDeEnergia() {
		estado.ahorroDeEnergia();
	}

	public Boolean estasEncendido() {
		return this.estado.getNombre().equals("encendido");
	}
	public Boolean estasApagado() {
		return this.estado.getNombre().equals("apagado");
	}

	public void agregarEstado(Estado e) {
		listaDeEstados.add(e);
	}
	
	public void setInicioPeriodo(LocalDateTime periodo) {
		this.inicioPeriodo = periodo;
	}
	
	public LocalDateTime getInicioPeriodo() {
		return inicioPeriodo;
	}
	
	//consumo en lo que va del mes
	public float consumoEnKw() {
		return consumidoComprendidoEntre(inicioPeriodo, LocalDateTime.now());		
	}
			
	public float consumidoUltimasNhoras (int cantHoras) {
		LocalDateTime fechaInicio = LocalDateTime.now().minusHours(cantHoras);
		LocalDateTime fechaFin = LocalDateTime.now();
		return this.consumidoComprendidoEntre(fechaInicio, fechaFin);
	}
	
	public float consumidoComprendidoEntre(LocalDateTime fechaInicio , LocalDateTime fechaFin) {
		float totalConsumo = 0;
		float totalHoras = 0;
		List<Estado> lstEstados;
		
		//Calculo consumo encendidos 		
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Encendido");
		totalHoras = this.totalDeHoras(lstEstados, fechaInicio, fechaFin);
		totalConsumo += totalHoras * this.getKwPorHora();
		
		//Calculo consumo ahorro de energia
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Ahorro de enegia");
		totalHoras = this.totalDeHoras(lstEstados, fechaInicio, fechaFin);
		totalConsumo += totalHoras * this.getKwPorHora() * coeficienteAhorroEnergia;
		
		return totalConsumo;
		
	}
	
	public List<Estado> listaDeEstadosSegun(LocalDateTime fechaInicio , LocalDateTime fechaFin, String tipoDeEstado) {
		List<Estado> lstEstadosSegun;
		lstEstadosSegun = listaDeEstados.stream().filter(e -> (cumpleCondicion(e,fechaInicio,fechaFin)) 
				&& ((e.getNombre().equals(tipoDeEstado)))).collect(Collectors.toList());
		return lstEstadosSegun;
		 
	}
			
	public boolean cumpleCondicion(Estado e, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return (e.getFechaInicio().isBefore(fechaFin) && e.getFechaFin().isAfter(fechaInicio));
	}
	
	public float totalDeHoras (List<Estado> lstEstados,  LocalDateTime fechaInicio, LocalDateTime fechaFin) {		
		LocalDateTime fechaMinima;
		LocalDateTime fechaMaxima;
		float totalHoras = 0;
			
		for (Estado estado : lstEstados){
			fechaMinima = this.fechaMaxima(fechaInicio, estado.getFechaInicio());
			fechaMaxima = this.fechaMinima(fechaFin, estado.getFechaFin());
			totalHoras += diferenciaHoras(fechaMinima, fechaMaxima);
		}
		return totalHoras;
	}
	
	public int diferenciaHoras(LocalDateTime unahora, LocalDateTime otrahora){
		int dif= (int) ChronoUnit.HOURS.between(unahora, otrahora);
		return dif;
	}
	
	public LocalDateTime fechaMaxima (LocalDateTime unaHora, LocalDateTime otraHora){
		if (unaHora.isAfter(otraHora)){
			return unaHora;
		}
		else {
			return otraHora;		
		}
	}
	
	public LocalDateTime fechaMinima (LocalDateTime unaHora, LocalDateTime otraHora){
		if (unaHora.isBefore(otraHora)){
			return unaHora;
		}
		else {
			return otraHora;		
		}
	}

}
