package ar.com.sge;

//import java.util.ArrayList;
import java.util.List;

public class Inteligente extends Dispositivo{
	List<Actuador> lactuadores;
	List<Sensor> lstSensores;
	
	public Inteligente(String _nombre, int _kwPorHora) {
		super(_nombre, _kwPorHora);
		
	}
	
	/* Pense que los dispositivos tiene como atributo 
	 * una lista de actuadores
	 */
	public List<Actuador> listarActuadores(){
		return lactuadores;
	}//fin listarActuadores
	public List<Sensor> listarSensores(){
		return lstSensores;
	}//fin listarSensores
	
	public void addActuador(Actuador unActuador) {
		listarActuadores().add(unActuador);
	}//fin addActador
	public void addSensor(Sensor unSensor) {
		listarSensores().add(unSensor);
	}//fin addActador

}// fin Inteligente
