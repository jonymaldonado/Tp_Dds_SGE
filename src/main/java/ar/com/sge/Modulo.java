package ar.com.sge;


public class Modulo extends DispositivoInteligente {

	private DispositivoEstandar dispositivoEstandar;
		

	public Modulo(String unNombre, int unkwPorHora) {
		super(unNombre,unkwPorHora);
	}
	
	public DispositivoEstandar getDispositivoEstandar() {
		return dispositivoEstandar;
	}

	public void setDispositivoEstandar(DispositivoEstandar dispositivoEstandar) {
		this.dispositivoEstandar = dispositivoEstandar;
	}
	
}
