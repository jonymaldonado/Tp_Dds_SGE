package ar.com.sge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente extends Usuario {
	
	private String tipoDoc;
	private int numeroDoc;
	private int telefono;	
	private List<DispositivoInteligente> lstDispositivosInteligentes;
	private List<DispositivoEstandar> lstDispositivosEstandares ;
	private Categoria categoria;
	private int puntos = 0;
	
	public Cliente(String _nombre, String _apellido,String _tipoDoc,int _numeroDoc) {		
		super(_nombre,_apellido);
		this.tipoDoc = _tipoDoc;
		this.numeroDoc = _numeroDoc;			
	}
	
	
	
	public Cliente(String _nombre, String _apellido, String tipoDoc, int numeroDoc, int telefono, Categoria categoria) {
		super(_nombre, _apellido);
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.telefono = telefono;
		this.lstDispositivosInteligentes  = new ArrayList<>();
		this.lstDispositivosEstandares  = new ArrayList<>();
		this.categoria = categoria;
		this.puntos = 0;
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
		
	public void agregarDispositivosEstandares(DispositivoEstandar unDispositivoEstandar) {
		lstDispositivosEstandares.add(unDispositivoEstandar);
	}
	public void agregarDispositivosInteligentes(DispositivoInteligente unDispositivoInteligente) {
		lstDispositivosInteligentes.add(unDispositivoInteligente);
		puntos += 15;
	}
	public void quitarDispositivosEstandares(DispositivoEstandar unDispositivoEstandar) {
		lstDispositivosEstandares.remove(unDispositivoEstandar);
	}
	public void quitarDispositivosInteligentes(DispositivoInteligente unDispositivoInteligente) {
		lstDispositivosInteligentes.remove(unDispositivoInteligente);
	}
	
	public void listarDispositivos(){
		this.lstDispositivosEstandares.forEach(dispositivoEstandar -> System.out.println(dispositivoEstandar.getNombre()));
		this.lstDispositivosInteligentes.forEach(dispositivosInteligente -> System.out.println(dispositivosInteligente.getNombre()));
	}
	
	public List<DispositivoInteligente> dispositivosEncendidos(){
		List<DispositivoInteligente> lstDispEnc;
		lstDispEnc = lstDispositivosInteligentes.stream().filter(d-> d.estasEncendido()==true).collect(Collectors.toList());
		return lstDispEnc;
	}
	
	public List<DispositivoInteligente> dispositivosApagados(){
		List<DispositivoInteligente> lstDispApag;
		lstDispApag = lstDispositivosInteligentes.stream().filter(d->d.estasApagado()==true).collect(Collectors.toList());
		return lstDispApag;
	}
	
	public int cantidadDispositivosEncendidos() {
		return dispositivosEncendidos().size();
	}
	
	public int cantidadDispositivosApagados() {
		return dispositivosApagados().size();
	}
	
	public int cantidadDeDispositivos() {
		return lstDispositivosInteligentes.size() + lstDispositivosEstandares.size();
	}	
	
	public float consumoDeEnergia() {
		float sum = 0;
		for(DispositivoInteligente d: lstDispositivosInteligentes) { 
			sum += d.consumoEnKw();
		}
		for(DispositivoEstandar d: lstDispositivosEstandares) { 
			sum += d.consumoEnKw();
		}
		return sum;
	}
	public float estimarFacturacion() {
		float vf = categoria.getValorFijo();
		float vv = categoria.getValorVariable();
		float resultado = vf + consumoDeEnergia() * vv;
		return resultado;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void agregarUnModuloA(DispositivoEstandar unDispositivoEstandar, Modulo unModulo) {
		unModulo.setDispositivoEstandar(unDispositivoEstandar);
		lstDispositivosInteligentes.add(unModulo);
		puntos += 10;
		quitarDispositivosEstandares(unDispositivoEstandar);		
	}
	
	
}
