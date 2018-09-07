package ar.com.sge.geografia;

import java.io.IOException;
import java.util.List;

import ar.com.sge.usuarios.Cliente;
import ar.com.sge.usuarios.RepoCliente;
import ar.com.sge.util.DaoJsonZona;
import ar.com.sge.util.DaoZona;


public class RepoZona {
	private DaoZona daoZonas;

	private List<Zona> listaZona;


	private static RepoZona instance;

	public RepoZona(DaoJsonZona dao) {
		this.daoZonas = dao;

	}

	public static RepoZona getInstance(DaoJsonZona dao) {
		if (instance == null)
			instance = new RepoZona(dao);
		return instance;
	}

	public void delete(Zona zona) throws IOException {
		this.daoZonas.delete(zona);

	}

	public List<Zona> getAllZonas() throws IOException {
		return daoZonas.getAll();
	}
	
	public void asignarZonas() throws IOException{
		listaZona=getAllZonas();
	}

	public void addZona(Zona unaZona) throws IOException {
		daoZonas.add(unaZona);
	}

	public void modificarZona(Zona zona) throws IOException {
		daoZonas.update(zona);
	}
	
	public void actualizarListasDeZonas(RepoTransformador repoTransformador) throws IOException{

		try {
			
			for (Transformador transformador : repoTransformador.getAllTransformadores()) {
				//double transformadorMasCercano = cliente.getDomicilio().distanciaAlPunto(listaTransformadores.get(0).getPosTransformador());
				for (Zona zona : getAllZonas()) {
					if(transformador.getIdZonaCorrespondiente()==zona.getIdZona()) {
						zona.agregarTransformador(transformador);
					}
				}
			}
					
					
			
		} catch (Exception e) {
		
		}
	}
	

	/*public void ubicarCliente(RepoCliente unrepo) throws IOException{
		List<Cliente> listaUsuario=unrepo.getAllUsuario();
		listaTransformadores
		
		
		
	}*/
	


}
