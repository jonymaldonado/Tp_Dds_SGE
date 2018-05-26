package ar.com.sge;

import java.util.List;
import java.util.stream.Collectors;

public class Cliente extends Usuario {
	
	private String tipoDoc;
	private int numeroDoc;
	private int telefono;
	
	private List<DispositivoInteligente> lstDispositivosInteligentes;
	private List<DispositivoEstandar> lstDispositivosEstandares;
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
	public void agregarDispositivosEstandar(DispositivoEstandar unDispositivoEstandar) {
		lstDispositivosEstandares.add(unDispositivoEstandar);
	}
	public void agregarDispositivosInteligente(DispositivoInteligente unDispositivoInteligente) {
		lstDispositivosInteligentes.add(unDispositivoInteligente);
	}
	public void listarDispositivos(){
		this.lstDispositivosEstandares.forEach(dispositivoEstandar -> System.out.println(dispositivoEstandar.getNombre()));
		this.lstDispositivosInteligentes.forEach(dispositivosInteligente -> System.out.println(dispositivosInteligente.getNombre()));
	}
	
	public int cantidadDeDispositivos() {
		return this.lstDispositivosInteligentes.size() + this.lstDispositivosEstandares.size();
	}
	
	public List<DispositivoInteligente> dispositivosEncendidos(){
		List<DispositivoInteligente> lstDispEnc;
		lstDispEnc = this.lstDispositivosInteligentes.stream().filter(dispoI-> dispoI.estasEncendido()).collect(Collectors.toList());
		return lstDispEnc;	
	}
	public List<DispositivoInteligente> dispositivosApagados(){
		List<DispositivoInteligente> lstDispEnc;
		lstDispEnc = this.lstDispositivosInteligentes.stream().filter(dispoI-> dispoI.estasApagado()).collect(Collectors.toList());
		return lstDispEnc;	
	}
	public int cantidadDispositivosEncendidos() {
		return dispositivosEncendidos().size();
	}
	public int cantidadDispositivosApagados() {
		return cantidadDeDispositivos() - cantidadDispositivosEncendidos();
	}
	/*	
	public float consumoDeEnergiaDispositi() {
		return listarDispositivos().stream().map(d->d.getKwConsumido()).count();
	}
	public float estimarFacturacion() {
		float vf = categoria.getValorFijo();
		float vv = categoria.getValorVariable();
		float resultado = vf + consumoDeEnergia() * vv;
		return resultado;
	}
	
	*/
	
}
