package ar.com.sge.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import ar.com.sge.dispositivos.DispositivoInteligente;
import ar.com.sge.dispositivos.IDispositivo;
import simplex.facade.SimplexFacade;


public class servicioSimplex {
	private SimplexFacade simplex;
	public void consultarSimplex(List<DispositivoInteligente> lista){
		ArrayList<Double> listavariables=new ArrayList<Double>();
		simplex = new SimplexFacade(GoalType.MAXIMIZE, true);
		double[] variables= new double[lista.size()];
		double[] variableskw= new double[lista.size()];
		int i=0;
		int tama�o=lista.size()-1;
		
		for(DispositivoInteligente elemento:lista) {
			//listavariables.add(1);
			variables[i]=1;
			variableskw[tama�o]=elemento.getKwPorHora();
			i++;
			tama�o--;
			
			
		}
		simplex.crearFuncionEconomica(variables);
		simplex.agregarRestriccion(Relationship.LEQ, 440640, variableskw);
		for(DispositivoInteligente elemento:lista) {
		
			for(int a=0; i<lista.size();i++) {
				if (elemento.getKwPorHora() == variableskw[a]) {
					variables[a] = 1;
				} else {
					variables[a] = 0;
				}
				
				
			
		}
		simplex.agregarRestriccion(Relationship.LEQ,elemento.getMaximoconsumo() , variables);
		simplex.agregarRestriccion(Relationship.GEQ,elemento.getMaximoconsumo() , variables);
		}
		
	}

}
