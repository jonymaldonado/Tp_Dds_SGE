package ar.com.sge.geografia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.sge.util.DaoJsonZona;
import ar.com.sge.util.DaoZona;


public class RepoZona {
	private DaoZona daoZonas;

	private List<Zona> listaZona;


	private static RepoZona instance;

	public RepoZona(DaoJsonZona dao) {
		this.daoZonas = dao;
		listaZona=new ArrayList<Zona>();

	}

	public static RepoZona getInstance(DaoJsonZona dao) {
		if (instance == null)
			instance = new RepoZona(dao);
		return instance;
	}

	public void delete(Zona zona) throws IOException {
		this.daoZonas.delete(zona);

	}
	public void getZonasjson() throws IOException {
		
		

		listaZona = daoZonas.getAll();
	}

	public List<Zona> getAllZonas() throws IOException {
		
		return listaZona;
		//return daoZonas.getAll();
	}

	public void addZona(Zona unaZona) throws IOException {
		daoZonas.add(unaZona);
	}

	public void modificarZona(Zona zona) throws IOException {
		daoZonas.update(zona);
	}
	
	public void actualizarListasDeZonas(RepoTransformador un_repo) throws IOException{
		for (Zona zona: this.getAllZonas()) {
			for (Transformador transformador : un_repo.getAllTransformadores()) {
				if (zona.getIdZona()==transformador.getIdZonaCorrespondiente()) {
					zona.agregarTransformador(transformador);
				}
			}
		}
	}
	

	/*public void ubicarCliente(RepoCliente unrepo) throws IOException{
		List<Cliente> listaUsuario=unrepo.getAllUsuario();
		listaTransformadores
		
		
		
	}*/
	


}
