package ar.com.sge;

public abstract class Categoria {

	public void categorizar(Cliente _cliente) {
		//categoriza a los nuevos clientes
	}
	public void recategorizar(Cliente _cliente) {
		double c = _cliente.consumoDeEnergia();
		String r;
		if(c <= 150) r="R1";
		else if(c>150 && c<=325) r="R2";
		else if(c>325 && c<=400) r="R3";
		else if(c>400 && c<=450) r="R4";
		else if(c>450 && c<=500) r="R5";
		else if(c>500 && c<=600) r="R6";
		else if(c>600 && c<=700) r="R7";
		else if(c>700 && c<=1400) r="R8";
		else r="R9";
		_cliente.setCategoria(r);
	}
	
	
}
