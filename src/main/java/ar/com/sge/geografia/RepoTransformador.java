package ar.com.sge.geografia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.sge.geografia.Transformador;
import ar.com.sge.usuarios.Cliente;
import ar.com.sge.usuarios.RepoCliente;
import ar.com.sge.usuarios.Usuario;
import ar.com.sge.util.DaoJsonTransformadores;
import ar.com.sge.util.DaoJsonZona;
import ar.com.sge.util.DaoTransFormadores;
import ar.com.sge.util.DaoZona;
public class RepoTransformador {
	private DaoTransFormadores daoTransformador;
	//private DaoZona daoZona;

	private List<Transformador> listaTransformadores;
	//private List<Zona> listazona;


	private static RepoTransformador instance;

	public RepoTransformador(DaoJsonTransformadores dao) {
		this.daoTransformador = dao;
		listaTransformadores=new ArrayList<Transformador>();
		
		//this.daoZona=daozona;

	}

	public static RepoTransformador getInstance(DaoJsonTransformadores dao) {
		if (instance == null)
			instance = new RepoTransformador(dao);
		return instance;
	}

	public void delete(Transformador transformador) throws IOException {
		this.daoTransformador.delete(transformador);

	}
	
	public void getTransformadoresjson() throws IOException {
		//listaTransformadores.clear();
		listaTransformadores= daoTransformador.getAll();
	}

	public List<Transformador> getAllTransformadores() throws IOException {
		return daoTransformador.getAll();
	}
	
	/*public List<Zona> getAllZona() throws IOException {
		return daoZona.getAll();
	}*/

	public void addTransformador(Transformador untransformador) throws IOException {
		daoTransformador.add(untransformador);
	}

	public void modificarTransformador(Transformador transformador) throws IOException {
		daoTransformador.update(transformador);
	}
	
	public void actualizarListasDeTransformadores(RepoCliente un_repo) {
		Transformador transfElegido=new Transformador();
		try {
			
			double distancia;
			for (Cliente cliente : un_repo.getAllUsuario()) {
				double transformadorMasCercano = cliente.getDomicilio().distanciaAlPunto(listaTransformadores.get(0).getPosTransformador());
				for (Transformador transformador : listaTransformadores) {
					distancia=cliente.getDomicilio().distanciaAlPunto(transformador.getPosTransformador());
					distancia=Math.abs(distancia);
					transformadorMasCercano=Math.abs(transformadorMasCercano);
					if (transformadorMasCercano>=distancia)  {
						transformadorMasCercano=distancia;
						//cliente.setIdTransformadorCorrespondiente(transformador.getIdtransformador());
						transfElegido=transformador;
					};//fin if
				}//fin for transfo
				//transfElegido=this.buscarTransformador(cliente.getIdTransformadorCorrespondiente());
				transfElegido.agregarCliente(cliente);
			};//fin for clientes
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	/*public void ubicarCliente(RepoCliente unrepo) throws IOException{
		List<Cliente> listaUsuario=unrepo.getAllUsuario();
		listaTransformadores
		
		
		
	}*/
	


}
