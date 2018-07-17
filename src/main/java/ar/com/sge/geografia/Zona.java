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
	};//constructor
	
	public float consumoTotalDelaZona() {
		float consumoTotal=0;
		for (Transformador unTransformador : listaDeTransformadores) {
			consumoTotal+=unTransformador.consumoTotalDelTransformador;
		}// fin for
		return consumoTotal;
	}//fin consumoTotalDelaZona

}// fin zona