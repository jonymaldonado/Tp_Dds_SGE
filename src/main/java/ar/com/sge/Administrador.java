package ar.com.sge;


public class Administrador extends Usuario{

	private int numeroId;
	
	
	public Administrador(String _nombre, String _apellido, int _numeroId) {
		super(_nombre,_apellido);
		this.numeroId = _numeroId;
	}
	public int getNumeroId() {
		return numeroId;
	}
	public int tiempoEnElCargo() {
		//retorna un tiempo
		return 0;
	}
}
