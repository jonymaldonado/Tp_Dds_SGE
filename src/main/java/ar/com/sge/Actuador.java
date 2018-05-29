package ar.com.sge;

import java.util.List;
import java.util.stream.Collectors;

public class Actuador {

	private List<comando> listacomandos;

	public void ejecutaraccion(String accion) {
		comando comandobuscado;
		List<comando> listafiltrada;
		listafiltrada = listacomandos.stream().filter(a -> a.getNombre().equalsIgnoreCase(accion))
				.collect(Collectors.toList());
		comandobuscado = listafiltrada.get(0);
		comandobuscado.ejecutar();

	}

	public List<comando> getListacomandos() {
		return listacomandos;
	}

	public void setListacomandos(List<comando> listacomandos) {
		this.listacomandos = listacomandos;
	}

	public void addcomando(comando comandonuevo) {
		listacomandos.add(comandonuevo);
	}

}
