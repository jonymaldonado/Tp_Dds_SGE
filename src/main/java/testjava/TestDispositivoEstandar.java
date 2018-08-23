package testjava;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.sge.dispositivos.DispositivoEstandar;
import ar.com.sge.usuarios.Categoria;
import ar.com.sge.usuarios.Cliente;

public class TestDispositivoEstandar {
	Categoria unaCategoriaR1;
	Cliente unCliente;
	DispositivoEstandar unDispoEstandar;
	
	@Before
	public void initialize() {
		unaCategoriaR1= new Categoria("R1", 18.76f, 0.644f);
		unCliente= new Cliente("John", "Doe", "dni", 12345678, 0, unaCategoriaR1, 0, 4.82f,4.65f);
		unDispoEstandar= new DispositivoEstandar("Ventilador de techo", (float) 17.5, 7);
		unCliente.agregarDispositivosEstandares(unDispoEstandar);
	}//fin initialize

	@Test
	public void testControlDeConsumoDeDispEstandar() {
		assertNotEquals("No corresponde al consumo que se esta esperando", 120.0, unCliente.consumoDeEnergia(), 1.0);
	}//fin testControlDeConsumoDeDispEstandar

}
