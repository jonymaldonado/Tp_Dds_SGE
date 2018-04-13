package ar.com.sge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente extends Usuario {
	
	private String tipoDoc;
	private int numeroDoc;
	private int telefono;
	private List<Dispositivo> lstDispositivos;
	private String categoria;
	
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
	public void setCategoria(String _categoria) {
		this.categoria = _categoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void agregarDispositivosCliente(List<Dispositivo> _dispositivo) {
		listarDispositivos().addAll(_dispositivo);
	}
	public List<Dispositivo> listarDispositivos(){
		return lstDispositivos;
	}
	public List<Dispositivo> dispositivosEncendidos(){
		List<Dispositivo> lstDispEnc = new ArrayList<Dispositivo>();
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
	public double consumoDeEnergia() {
		return listarDispositivos().stream().map(d->d.getKwConsumido()).count();
	}
	public double estimarFacturacion() {
		double a = 0;
		double c = consumoDeEnergia();
		switch(categoria) {
		case "R1": a = 18.76 + (c*0.644); break;
		case "R2": a = 35.32 + (c*0.644); break;
		case "R3": a = 60.71 + (c*0.681); break;
		case "R4": a = 71.74 + (c*0.738); break;
		case "R5": a = 110.38 + (c*0.794); break;
		case "R6": a = 220.75 + (c*0.832); break;
		case "R7": a = 443.59 + (c*0.851); break;
		case "R8": a = 545.96 + (c*0.851); break;
		case "R9": a = 887.19 + (c*0.851); break;
		default: System.out.println("no existe la categoria");
		}
		return a;
	}
	
	
	
}
