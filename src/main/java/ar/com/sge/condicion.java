package ar.com.sge;

import java.util.Date;
import java.util.List;



public class condicion {
	
	
	private String operador;
	
	private Double valorcomparacion;
	
	


	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private IMetodologia metodologia;
	
	public condicion(){
		
	}
	public condicion(String operacion) {
	
		this.operador=operacion;
	
	}
	public boolean  evaluar(int valor) {

		if (operador.equalsIgnoreCase("mayor")) {
			return valor>valorcomparacion;
		}else if(operador.equalsIgnoreCase("menor")) {
			return valor<valorcomparacion;
		}else {
			return valor==valorcomparacion;
		}
		
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
