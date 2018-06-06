package testjava;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.sge.Actuador;
import ar.com.sge.AdapterApagar;
import ar.com.sge.AdapterEncender;
import ar.com.sge.Comando;
import ar.com.sge.ComandoApagar;
import ar.com.sge.ComandoEncender;
import ar.com.sge.DispositivoInteligente;
import ar.com.sge.Encendido;
import ar.com.sge.Estado;
import ar.com.sge.Regla;
import ar.com.sge.Sensor;

public class testEntrega1 {
	private Actuador actuador1;
	private Sensor sensor1;
	private Regla regla1;
	private Comando comandoprender;
	private Comando comandoApagar;
	private DispositivoInteligente inteligente1;
	private Encendido estado1 ,estado2;
	private AdapterApagar adapterApagar;
	private AdapterEncender adapterEncender;
	private LocalDateTime inicioestado,inicioestado2;
	private LocalDateTime finestado,finestado2;
	
	@Before
	public void init(){
		inteligente1=new DispositivoInteligente("tv", 28);
		actuador1=new Actuador();
		sensor1=new Sensor();
		regla1=new Regla("mayor",25,"encender",actuador1);
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
		inteligente1.agregarEstado(estado1);
		inteligente1.agregarEstado(estado2);
		inteligente1.setSensor(sensor1);
		
			
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
	
	
		
		

	
	

	
}
