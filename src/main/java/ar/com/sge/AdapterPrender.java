package ar.com.sge;

public class AdapterPrender implements Comando {
	private Fabricante fabricante;
	
	public AdapterPrender(){
		fabricante = new Fabricante();
	}
	
	@Override
	public void ejecutar() {
		fabricante.prendete();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}
