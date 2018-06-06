package ar.com.sge;

public class Regla {
	private Condicion condicion;
	private Actuador actuador;
	private String accion;

	public void verificarRegla(float valor) {
		if (condicion.evaluar(valor)) {
			actuador.ejecutaraccion(accion);
		}
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

}
