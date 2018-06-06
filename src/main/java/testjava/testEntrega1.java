package testjava;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.sge.*;

public class testEntrega1 {
	private Actuador actuador1;
	private Sensor sensor1;
	private Regla regla1;
	private Comando comandoprender;
	private Comando comandoApagar;
	private Comando comandoAhorroDeEnergia;
	private DispositivoInteligente inteligente1;
	private Encendido estado1 ,estado2;
	private Apagado apagado1;
	private AhorroDeEnergia estadoahorro;
	private AdapterApagar adapterApagar;
	private AdapterEncender adapterEncender;
	private AdapterAhorroDeEnergia adapterAhorroDeEnergia;
	private LocalDateTime inicioestado,inicioestado2,inicioapagado;
	private LocalDateTime finestado,finestado2,finapagado;
	
	@Before
	public void init(){
		inteligente1=new DispositivoInteligente("tv", 28);
		actuador1=new Actuador();
		sensor1=new Sensor();
		regla1=new Regla("mayor",25,"apagar",actuador1);
		sensor1.agregarObservador(regla1);
		adapterApagar=new AdapterApagar();
		adapterEncender=new AdapterEncender();
		comandoApagar=new ComandoApagar(adapterApagar,"apagar",inteligente1);
		comandoprender=new ComandoEncender(adapterEncender,"encender",inteligente1);
		inicioestado=LocalDateTime.of(2018, 6, 5, 10, 00);
		finestado=LocalDateTime.of(2018, 6, 5, 12, 00);
		estado1=new Encendido("encendido",inicioestado,finestado,56);
		inicioestado2=LocalDateTime.of(2018, 6, 5, 14, 00);
		finestado2=LocalDateTime.of(2018, 6, 5, 15, 00);
		estado2=new Encendido("encendido",inicioestado2,finestado2,28);
		inicioapagado=LocalDateTime.of(2018, 6, 5, 12, 00);
		finapagado=LocalDateTime.of(2018, 6, 5, 14, 00);
		apagado1=new Apagado("apagado", inicioapagado, finapagado);
		inteligente1.agregarEstado(estado1);
		inteligente1.agregarEstado(estado2);
		inteligente1.setSensor(sensor1);
		actuador1.addcomando(comandoApagar);
		actuador1.addcomando(comandoprender);
		comandoAhorroDeEnergia=new ComandoAhorroDeEnergia(adapterAhorroDeEnergia,"ahorroDeEnergia",inteligente1);
		actuador1.addcomando(comandoAhorroDeEnergia);
		
			
	}	
	
	@Test
	public void obtenerconsumoestadosentreelrango() {
		float consumo,horastotal;
		consumo=inteligente1.consumidoUltimasNhoras(24);
		Assert.assertTrue(inteligente1.getEstados().size()==2);
		LocalDateTime hoy=LocalDateTime.of(2018, 6, 6, 9,0 );
		LocalDateTime ayer=LocalDateTime.of(2018, 6, 5, 9,0 );
		float consumido=inteligente1.consumidoComprendidoEntre(ayer,hoy);
		Assert.assertTrue(consumido==84.0);
		Assert.assertTrue(inteligente1.listaDeEstadosSegun(ayer, hoy, "encendido").size()==2);
		Assert.assertTrue(inteligente1.cumpleCondicion(estado1, ayer, hoy));
		Assert.assertTrue(inteligente1.cumpleCondicion(estado2, ayer, hoy));
		horastotal=inteligente1.totalDeHoras(inteligente1.listaDeEstadosSegun(ayer, hoy, "encendido"), ayer, hoy);

		System.out.println("hora total "+horastotal);
		Assert.assertTrue(horastotal==3);
				Assert.assertTrue(consumo==84);
		}
	
	@Test
	public void obtenerconsumoestadofuerarango() {
		float consumo;
		LocalDateTime hoy=LocalDateTime.of(2018, 6, 6, 9,0 );
		LocalDateTime ayer=LocalDateTime.of(2018, 6, 5, 11,30 );
		consumo=inteligente1.consumidoComprendidoEntre(ayer,hoy);
		//Assert.assertTrue(consumo==56.0);
		Assert.assertTrue(consumo==42.0);
		
		
	}
	
	@Test
	public void prenderDispositivo() {
		comandoprender.ejecutar();
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "encendido");
	}
	
	@Test
	public void apagarDispositivo() {
		comandoprender.ejecutar();
		comandoApagar.ejecutar();
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "apagado");
	}
	
	@Test
	public void ahorroDeEnergiaDispositivo() {
		comandoprender.ejecutar();
		comandoAhorroDeEnergia.ejecutar();
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "modo ahorro");
	}
	@Test
	public void tomarmedicion() {
		comandoprender.ejecutar();
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "encendido");
		sensor1.setValor(30);
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "apagado");
	}
	@Test
	public void tomarmedicionnocumpleRegla() {
		comandoprender.ejecutar();
		Assert.assertTrue(inteligente1.getEstado().getNombre()== "encendido");
		sensor1.setValor(22);
		Assert.assertFalse(inteligente1.getEstado().getNombre()== "apagado");
	}
	
	
		
		

	
	

	
}
