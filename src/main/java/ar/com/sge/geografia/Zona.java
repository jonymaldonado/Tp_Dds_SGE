package ar.com.sge.geografia;

import java.util.ArrayList;
import java.util.List;

public class Zona {
	private int idZona;
	private String nombreDeLaZona;
	private Coordenada posZonaCentral;
	private int radioEnMetros;
	private List<Transformador> listaDeTransformadores; 
	
	public Zona() {
		this.listaDeTransformadores=new ArrayList<>();
	}//constructor
	
	public Zona(int id, String nombre, double latitud, double longitud,int radio) {
		this.setIdZona(id);
		this.setNombreDeLaZona(nombre);
		this.setPosZonaCentral(new Coordenada(latitud, longitud));
		this.setRadioEnMetros(radio);
		this.listaDeTransformadores=new ArrayList<>();
	}//constructor
	

	//}//fin consumoTotalDelaZona
	public float consumoTotalDeLaZona() {
		float consumoTotalEnLaZona = 0 ;
		for (Transformador unTransformador : listaDeTransformadores) {
			consumoTotalEnLaZona +=  unTransformador.totalDeConsumoDelTransformadores();
		}
		return consumoTotalEnLaZona;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getNombreDeLaZona() {
		return nombreDeLaZona;
	}

	public void setNombreDeLaZona(String nombreDeLaZona) {
		this.nombreDeLaZona = nombreDeLaZona;
	}

	public Coordenada getPosZonaCentral() {
		return posZonaCentral;
	}

	public void setPosZonaCentral(Coordenada posZonaCentral) {
		this.posZonaCentral = posZonaCentral;
	}

	public int getRadioEnMetros() {
		return radioEnMetros;
	}

	public void setRadioEnMetros(int radioEnMetros) {
		this.radioEnMetros = radioEnMetros;
	}

	public List<Transformador> getListaDeTransformadores() {
		return listaDeTransformadores;
	}

	public void setListaDeTransformadores(List<Transformador> listaDeTransformadores) {
		this.listaDeTransformadores = listaDeTransformadores;
	}

	public void agregarTransformador(Transformador transformador) {
		this.getListaDeTransformadores().add(transformador);		
	}
	
	
	
	
	
}// fin zona