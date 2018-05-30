package ar.com.sge;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DispositivoInteligente{

	private String nombre;
	protected float kwPorHora;
	protected Boolean encendido = false;
	private Estado estado;
	private List<Estado> listaDeEstados = new ArrayList<Estado>();
	private static final double coeficienteAhorroEnergia = 0.6;
	private LocalDateTime inicioPeriodo;
	private Sensor sensor;

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
		return this.estado.getNombre().equals("Encendido");
	}
	public Boolean estasApagado() {
		return this.estado.getNombre().equals("Apagado");
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
		List<Estado> lstEstados;
		
		//Calculo consumo encendidos 		
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Encendido");
		totalConsumo += this.totalDeConsumo(lstEstados);
		
		//Calculo consumo ahorro de energia
		lstEstados = this.listaDeEstadosSegun(fechaInicio, fechaFin, "Ahorro de enegia");
		totalConsumo += this.totalDeConsumo(lstEstados) * coeficienteAhorroEnergia;
		
		return totalConsumo;
	}
	
	public List<Estado> listaDeEstadosSegun(LocalDateTime fechaInicio , LocalDateTime fechaFin, String tipoDeEstado) {
		List<Estado> lstEstadosSegun;
		lstEstadosSegun = listaDeEstados.stream().filter(e -> (cumpleCondicion(e,fechaInicio,fechaFin)) 
				&& ((e.getNombre().equals(tipoDeEstado)))).collect(Collectors.toList());
		return lstEstadosSegun;
		 
	}
	
	public float totalDeConsumo(List<Estado> lstEstados) {		
		float totalConsumo = 0;		
		for (Estado estado : lstEstados){
			totalConsumo += estado.getConsumo();
		}
		return totalConsumo;
	}
		
	public boolean cumpleCondicion(Estado e, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return (e.getFechaInicio().isBefore(fechaFin) && e.getFechaFin().isAfter(fechaInicio));
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	//activo el sensor y como parametro le indico las cada cuantas horas se va a ejecutar
	public void activarSensor(int valor){
		sensor.activate(this,valor);
	}
	
	public void desactivarSensor() {
		sensor.desactivate();
	}

}
