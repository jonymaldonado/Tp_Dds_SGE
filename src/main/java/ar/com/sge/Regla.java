package ar.com.sge;

public class Regla {
	
	private Comando comando;
	private float valorDeReferencia;
	private DispositivoInteligente dispositivo;

	public void notificar(float valor) {
		elegirComando(valor);
		comando.ejecutar(dispositivo);
	}
	public void elegirComando(float valor) {
		if(valor>=valorDeReferencia) {
			this.comando = new ComandoApagar();
		}else {
			this.comando = new ComandoEncender();
		}
	}
}
