package ar.com.sge;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Sensor {
	
	private List<Regla> observadores = new ArrayList<>();
	private TimerTask tarea;
	
	public void activate(DispositivoInteligente dispositivo,int horas){
		programarTarea(dispositivo, horas);
	}

	public void programarTarea(DispositivoInteligente dispositivo, int horas) {
		Timer timer = new Timer();
		this.tarea = new TimerTask(){
			public void run() {
				medir(dispositivo);
			}
		};
		int tiempo = horas * 3600000;
		timer.schedule(tarea,tiempo,tiempo);//se jecuta cada N horas 
	}

	public void medir(DispositivoInteligente dispositivo){
		float valor = dispositivo.consumoEnKw();
		observadores.forEach(r -> r.verificarRegla(valor));
	}	
	
	public void desactivate(){
		tarea.cancel();
	}

	public void agregarObservador(Regla regla){
		observadores.add(regla);
	}
	
}











