package ar.com.sge.usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.sge.dispositivos.DispositivoEstandar;
import ar.com.sge.dispositivos.DispositivoInteligente;
import ar.com.sge.dispositivos.IDispositivo;
import ar.com.sge.dispositivos.Modulo;
import ar.com.sge.geografia.Coordenada;

public class Cliente extends Usuario {
	
	private String tipoDoc;
	private int numeroDoc;
//	private Coordenada domicilio;
	private int telefono;	
	private List<DispositivoInteligente> lstDispositivosInteligentes ;
	private List<DispositivoEstandar> lstDispositivosEstandares ;
	private Categoria categoria;
	private int puntos = 0;
	
	public Cliente(String _nombre, String _apellido,String _tipoDoc,int _numeroDoc,double latitud,double longitud) {		
		super(_nombre,_apellido,latitud,longitud);
		this.tipoDoc = _tipoDoc;
		this.numeroDoc = _numeroDoc;
		lstDispositivosInteligentes = new ArrayList<>();
		lstDispositivosEstandares = new ArrayList<>();
	}
	
	public Cliente(String _nombre, String _apellido, String tipoDoc, int numeroDoc, int telefono, Categoria categoria,int puntos,double latitud,double longitud ) {
		super(_nombre, _apellido,latitud,longitud);
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
	/*public void agregarDispositivosInteligentes(IDispositivo unDispositivoInteligente) {
		lstDispositivosInteligentes.add(unDispositivoInteligente);
		puntos += 15;
	}*/
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
		return this.dispositivosEncendidos().size();
	}
	
	public int cantidadDispositivosApagados() {
		return dispositivosApagados().size();
	}
	
	public int cantidadDeDispositivos() {
		return this.cantidadDedispositivosInteligentes() + this.cantidadDeDispositivosEstandares();
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
	public float facturacionEntre(LocalDateTime inicioPeriodo,LocalDateTime finPeriodo){
		float resultado=0;
		float resultadototal=0;
		
		float vf = categoria.getValorFijo();
		float vv = categoria.getValorVariable();
		for(DispositivoInteligente d: lstDispositivosInteligentes) { 
			resultado += d.consumidoComprendidoEntre(inicioPeriodo, finPeriodo);
		}
		resultadototal = vf + resultado * vv;
		return resultadototal;
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
	
	public int cantidadDedispositivosInteligentes() {
		return lstDispositivosInteligentes.size();
	}
	
	public int cantidadDeDispositivosEstandares() {
		return lstDispositivosEstandares.size();
	}
}
