package testjava;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import ar.com.sge.dispositivos.DispositivoInteligente;
import ar.com.sge.geografia.*;
import ar.com.sge.usuarios.*;

public class TestProcesoDeListas {
	private Transformador transformador1, transformador2, transformador3;
	private Cliente cliente1,cliente2,cliente3,cliente4,cliente5; 
//	Categoria unaCategoriaR1;
	private DispositivoInteligente unTV40,aire1,unaHeladera,unaHeladera2, pc1, pc2, aire2; 
	Administrador admin;
	private Zona zona1,zona2, zona3;
	
	@Before
	public void inicializarVariables() {
//		ADMINISTRADOR
		admin= new Administrador("Jony", "Maldo",1986);
//		ZONAS
		zona1=new Zona(243, "zona1", 45.86, 33.12, 15);
		zona2=new Zona(876, "zona2", -54.54, -55.32, 5);
		zona3=new Zona(446, "zona3", 60.00, 3.82, 39);
//		TRANSFORMADORES
		transformador1=new Transformador(001, -43.55f, 3.44f,243);
		transformador2=new Transformador(002, 54.47f,-24.55f,446);
		transformador3=new Transformador(003, 55.55f, 3.23f,446);
//		CLIENTES
		cliente1= new Cliente("Carlos","Ligorria", "DNI", 14555666, 54363366, 54.44f, 2.65f);
		cliente2= new Cliente("Leonardo","Silva", "DNI", 66664554, 86543345, 55.44f, 65.65f);
		cliente3= new Cliente("Gustavo","Apaza", "DNI", 37543232, 54674744, 22.44f, 6.87f);
		cliente4= new Cliente("Roberto","Castro", "DNI", 44545532, 34565437, -5.44f, 33.65f);
		cliente5= new Cliente("Susana ","Mosquera", "DNI", 54876578, 78874744, 9.44f, 65.00f);
//		DISPOSITIVOS
		unTV40=new DispositivoInteligente("unTV40", 0.08f);
		aire1=new DispositivoInteligente("aire1", 1013f);
		unaHeladera=new DispositivoInteligente("unaHeladera", 0.075f);
		unaHeladera2=new DispositivoInteligente("unaHeladera2", 0.09f);
		pc1=new DispositivoInteligente("pc1", 0.4f);
		pc2=new DispositivoInteligente("pc2", 0.4f);
		aire2 =new DispositivoInteligente("aire2", 1613f);
//		TEST CLIENTE EN CADA TRANSFORMADOR
		cliente1.agregarDispositivosInteligentes(pc1);
		cliente1.agregarDispositivosInteligentes(aire2);
		cliente1.agregarDispositivosInteligentes(unaHeladera2);
		
		cliente2.agregarDispositivosInteligentes(unTV40);
		
		cliente3.agregarDispositivosInteligentes(aire1);
		cliente3.agregarDispositivosInteligentes(aire2);
		cliente3.agregarDispositivosInteligentes(pc2);
		cliente3.agregarDispositivosInteligentes(pc1);
		
		cliente4.agregarDispositivosInteligentes(aire2);
		cliente4.agregarDispositivosInteligentes(pc2);
		
		cliente5.agregarDispositivosInteligentes(unaHeladera);
		cliente5.agregarDispositivosInteligentes(pc1);
		cliente5.agregarDispositivosInteligentes(unTV40);

		admin.agregarTransformadores(transformador1);
		admin.agregarTransformadores(transformador2);
		admin.agregarTransformadores(transformador3);
		
		admin.agregarCliente(cliente1);
		admin.agregarCliente(cliente2);
		admin.agregarCliente(cliente3);
		admin.agregarCliente(cliente4);
		admin.agregarCliente(cliente5);
		
		admin.actualizarListasDeTransformadores();
//		TEST TRANSFORMADOR EN CADA ZONA

		admin.agregarZonas(zona1);
		admin.agregarZonas(zona2);
		admin.agregarZonas(zona3);
		admin.actualizarListasDeZonas();
	}

	@Test
	public void testClienteEnCadaTRansformador() {
		int dni1, dni2,dni3,dni4,dni5;
		dni1=14555666;
		dni2=66664554;
		dni3=37543232;
		dni4=44545532;
		dni5=54876578;

		//testear size de las listas de los transformadores
		assertEquals(3, transformador1.getListaDeclientesConectados().size());
		assertEquals(2, transformador2.getListaDeclientesConectados().size());
		assertEquals(0, transformador3.getListaDeclientesConectados().size());
		//testeo dni de cada cliente
		assertEquals(dni1, transformador1.getListaDeclientesConectados().get(0).getNumeroDoc());
		assertEquals(dni2, transformador1.getListaDeclientesConectados().get(1).getNumeroDoc());
		assertEquals(dni3, transformador1.getListaDeclientesConectados().get(2).getNumeroDoc());
		assertEquals(dni4, transformador2.getListaDeclientesConectados().get(0).getNumeroDoc());
		assertEquals(dni5, transformador2.getListaDeclientesConectados().get(1).getNumeroDoc());
		
	}//fin test 1
	@Test
	public void testTransformadorEnCadaZona() {
	
//		testear size de las listas de las zonas
		assertEquals(1, zona1.getListaDeTransformadores().size());
		assertEquals(0, zona2.getListaDeTransformadores().size());
		assertEquals(2, zona3.getListaDeTransformadores().size());
//		testear el id de los transformadores en cada zona con listas no llenas
		assertEquals(1, zona1.getListaDeTransformadores().get(0).getIdtransformador());
		assertEquals(2, zona3.getListaDeTransformadores().get(0).getIdtransformador());
		assertEquals(3, zona3.getListaDeTransformadores().get(1).getIdtransformador());
	
	}//fin test 2

}//Fin TestActualizarListas

