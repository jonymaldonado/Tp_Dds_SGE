package ar.com.sge;

import java.util.List;
import java.util.stream.Collectors;

public class Cliente extends Usuario {
	
	private String tipoDoc;
	private int numeroDoc;
	private int telefono;
	private List<Dispositivo> lstDispositivos;
	private Categoria categoria;
	
	public Cliente(String _nombre, String _apellido,String _tipoDoc,int _numeroDoc) {		
		super(_nombre,_apellido);
		this.tipoDoc = _tipoDoc;
		this.numeroDoc = _numeroDoc;			
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public int getNumeroDoc() {
		return numeroDoc;
	}
	public void setTelefono(int _unNumero) {
		this.telefono = _unNumero;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setCategoria(Categoria _categoria) {
		this.categoria = _categoria;
	}
	public String getCategoria() {
		return categoria.getNombre();
	}
	public void agregarDispositivosCliente(Dispositivo _dispositivo) {
		lstDispositivos.add(_dispositivo);
	}
	public List<Dispositivo> listarDispositivos(){
		return lstDispositivos;
	}
	public List<Dispositivo> dispositivosEncendidos(){
		List<Dispositivo> lstDispEnc;
		lstDispEnc = listarDispositivos().stream().filter(d-> d.getEncendido()==true).collect(Collectors.toList());
		return lstDispEnc;	
	}
	public int cantidadDispositivosEncendidos() {
		return dispositivosEncendidos().size();
	}
	public int cantidadDispositivosApagados() {
		return cantidadDeDispositivos() - cantidadDispositivosEncendidos();
	}
	public int cantidadDeDispositivos() {
		return listarDispositivos().size();
	}	
	public float consumoDeEnergia() {
		return listarDispositivos().stream().map(d->d.getKwConsumido()).count();
	}
	public float estimarFacturacion() {
		float vf = categoria.getValorFijo();
		float vv = categoria.getValorVariable();
		float resultado = vf + consumoDeEnergia() * vv;
		return resultado;
	}
	
	
	
}
