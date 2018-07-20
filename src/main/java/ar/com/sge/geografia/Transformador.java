package ar.com.sge.geografia;

import java.util.ArrayList;
import java.util.List;

import ar.com.sge.usuarios.Cliente;

public class Transformador {
	public int idtransformador; //por ahora va int, despues vemos se vera si queda asi o String
	public Coordenada posTransformador;
	public int idZonaCorrespondiente;
	public List <Cliente> listaDeclientesConectados;
	//public Enum<Enum<E>> estado;  no si si vale la oena podner el atributo
	
	public Transformador(){
		this.listaDeclientesConectados= new ArrayList<>(); 
	};//constructor
	
/*
 * 	public float consumoTotalDelTransformador() {
		float consumoDeEnergia=0;
		for (Cliente unCliente : listaDeclientesConectados) {
			consumoDeEnergia+=unCliente.consumoDeEnergia();
		}//fin for
		return consumoDeEnergia;
	}*/
	public int getIdtransformador() {
		return idtransformador;
	}
	public void setIdtransformador(int idtransformador) {
		this.idtransformador = idtransformador;
	}
	public Coordenada getPosTransformador() {
		return posTransformador;
	}
	public void setPosTransformador(Coordenada posTransformador) {
		this.posTransformador = posTransformador;
	}
	public int getIdZonaCorrespondiente() {
		return idZonaCorrespondiente;
	}
	public void setIdZonaCorrespondiente(int idZonaCorrespondiente) {
		this.idZonaCorrespondiente = idZonaCorrespondiente;
	}
	public void 
}//fin Trasnformador
