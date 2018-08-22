package ar.com.sge.usuarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import ar.com.sge.geografia.*;

public class Administrador extends Usuario{

	private int numeroId;
	private List<Cliente>listaDeClientes;
	private List<Transformador> listaDeTransformadoresActivos;
	private List<Zona> listaDeZonas;
	
	
	public Administrador(String _nombre, String _apellido, int _numeroId) {
		super(_nombre,_apellido);
		this.numeroId = _numeroId;
		this.listaDeClientes= new ArrayList<>();
		this.listaDeTransformadoresActivos= new ArrayList<>();
		this.listaDeZonas= new ArrayList<>();
	}
	public List<Transformador> getListaDeTransformadoresActivos() {
		return listaDeTransformadoresActivos;
	}
	public List<Zona> getListaDeZonas() {
		return listaDeZonas;
	}
	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	public void setListaDeTransformadoresActivos(List<Transformador> listaDeTransformadoresActivos) {
		this.listaDeTransformadoresActivos = listaDeTransformadoresActivos;
	}
	public void setListaDeZonas(List<Zona> listaDeZonas) {
		this.listaDeZonas = listaDeZonas;
	}
	
	public int getNumeroId() {
		return numeroId;
	}
	public void tiempoEnElCargo() {
		LocalDate ini = getAlta();
		LocalDate fin = LocalDate.now();
		int days = Period.between(ini,fin).getDays();
		int months = Period.between(ini,fin).getMonths();
		int years = Period.between(ini,fin).getYears();
		System.out.println(years+" anio, "+ months +" meses, "+days+" dias");
	}
	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}
//	public void agregarCliente(Cliente unClientes) {
//		this.listaDeClientes.add(unClientes);
//	}
	public  List<Transformador> cargarJsonTransformadores(String archivoJson) throws FileNotFoundException{
		List<Transformador> transformadoresActivos= new ArrayList<Transformador>();
		Type type= new TypeToken<ArrayList<Transformador>>() { }.getType();
		Gson gson =new Gson();
		JsonReader json= new JsonReader(new FileReader(archivoJson));
		transformadoresActivos =gson.fromJson(json,type);
		return transformadoresActivos;
	}
	
	
	public List<Zona> cargarJsonZonas(String archivoJson) throws FileNotFoundException{
		List<Zona> listaDeZona= new ArrayList<Zona>();
		Type type= new TypeToken<ArrayList<Zona>>() { }.getType();
		Gson gson =new Gson();
		JsonReader json= new JsonReader(new FileReader(archivoJson));
		listaDeZona =gson.fromJson(json,type);
		return listaDeZona;
	}
	
	public void cargarJson(String archivoJsonTransformadores, String archivoJsonZonas) throws FileNotFoundException {
		this.setListaDeTransformadoresActivos(this.cargarJsonTransformadores(archivoJsonTransformadores));
		this.setListaDeZonas(this.cargarJsonZonas(archivoJsonZonas));
	}
	
	

	/*public void actualizarListasDeTransformadores() {
		float transformadorMasCercano=0;
		for (Cliente cliente : listaDeClientes) {
			for (Transformador transformador : listaDeTransformadoresActivos) {
				cliente.
			}
			
		}
		
	}*/
}
 