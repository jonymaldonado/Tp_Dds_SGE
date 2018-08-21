package testjava;

import static org.junit.Assert.*;

import org.apache.commons.math3.optim.PointValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.sge.dispositivos.DispositivoInteligente;
import ar.com.sge.dispositivos.IDispositivo;
import ar.com.sge.usuarios.Categoria;
import ar.com.sge.usuarios.Cliente;

public class TestSimplex {
	
	private Cliente cliente1;
	private DispositivoInteligente tv , lavarropa,ventilador;
	private Categoria categoria1;
	private PointValuePair solucion;
	
	@Before
	public void init() {
		categoria1=new Categoria("residencial",12,1);
		cliente1=new Cliente("tomas","perez","dni",123212,482122,categoria1,0,41,42);
		tv =new DispositivoInteligente("LCD 40", 0.18);
		tv.setMinimoconsumo(90);
		tv.setMaximoconsumo(370);
		lavarropa =new DispositivoInteligente("Lavarropa 5kg", 0.875);
		lavarropa.setMinimoconsumo(6);
		lavarropa.setMaximoconsumo(30);
		ventilador =new DispositivoInteligente("ventilador techo", 0.06);
		ventilador.setMinimoconsumo(120);
		ventilador.setMaximoconsumo(360);
		cliente1.agregarDispositivosInteligentes(tv);
		cliente1.agregarDispositivosInteligentes(lavarropa);
		cliente1.agregarDispositivosInteligentes(ventilador);
	}
	
	@Test
	public void usarsimplex() {
		solucion=cliente1.consultarASimplex();
		Assert.assertEquals(760, solucion.getValue(), 0.01);
		Assert.assertEquals(360, solucion.getPoint()[0], 0.01); // <--- X2
		Assert.assertEquals(30, solucion.getPoint()[1], 0.01); // <--- X1
		Assert.assertEquals(370, solucion.getPoint()[2], 0.01); // <--- X0
	}

	

}
