package testjava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.sge.usuarios.Administrador;

public class TestListaDeAlgo {
	//get private String archivoJson;
	private ArrayList<Integer> transformadoresActivos;
	private Administrador admin;
	@Before
	
	public void inicializar() {
	//	archivoJson= String."document.json");
//		archivoJson="{\r\n" + 
//				"  \"transformadoresActivos\": [\r\n" + 
//				"    1,\r\n" + 
//				"    2,\r\n" + 
//				"    3\r\n" + 
//				"  ]\r\n" + 
//				"}";
		transformadoresActivos= new ArrayList<>();
	
		admin=new Administrador("Carlos", "Losares", 2334);
		
	};
	@Test
	public void testLista() throws FileNotFoundException {
		transformadoresActivos.add(1);
		transformadoresActivos.add(2);
		transformadoresActivos.add(3);
		admin.cargarJsonTransformadores(archivoJson);
		Assert.assertEquals(admin.getListaDeTransformadoresActivos(), transformadoresActivos); 
	
	}

}
