package ar.com.sge;


public class Condicion {
	
	
	private String operador;
	
	private Double valorcomparacion;
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private IMetodologia metodologia;
	
	public Condicion(){
		
	}
	public Condicion(String operacion) {
	
		this.operador=operacion;
	
	}
	public boolean evaluar(float valor) {

		boolean a;
		
		if (operador.equalsIgnoreCase("mayor")) {
			a = valor>valorcomparacion;
		}
		else if(operador.equalsIgnoreCase("menor")) {
			a = valor<valorcomparacion;
		}
		else {
			a = valor==valorcomparacion;
		}		
		return a;		
	}
		
	public String getOperador() {
		return operador;
	}
	
	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	public Double getValorcomparacion() {
		return valorcomparacion;
	}
	
	public void setValorcomparacion(Double valorcomparacion) {
		this.valorcomparacion = valorcomparacion;
	}
	
	

}
