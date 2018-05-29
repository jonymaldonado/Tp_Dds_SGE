package ar.com.sge;

public class regla {
	private condicion condicion;
	private actuador actuador;
	private String accion;
	
	public void verificarregla(int valor) {
		if(condicion.evaluar(valor)) {
			actuador.ejecutaraccion(accion);
		}
	}
	public condicion getCondicion() {
		return condicion;
	}
	public void setCondicion(condicion condicion) {
		this.condicion = condicion;
	}
	public actuador getActuador() {
		return actuador;
	}
	public void setActuador(actuador actuador) {
		this.actuador = actuador;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	

}
