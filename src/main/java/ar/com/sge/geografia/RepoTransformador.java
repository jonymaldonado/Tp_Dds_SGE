package ar.com.sge.geografia;

import java.io.IOException;
import java.util.List;

import ar.com.sge.geografia.Transformador;
import ar.com.sge.util.DaoJsontransformadores;
import ar.com.sge.util.DaoTransFormadores;
public class RepoTransformador {
	private DaoTransFormadores daoTransformador;

	private static RepoTransformador instance;

	public RepoTransformador(DaoJsontransformadores dao) {
		this.daoTransformador = dao;

	}

	public static RepoTransformador getInstance(DaoJsontransformadores dao) {
		if (instance == null)
			instance = new RepoTransformador(dao);
		return instance;
	}

	public void delete(Transformador transformador) throws IOException {
		this.daoTransformador.delete(transformador);

	}

	public List<Transformador> getAllUsuario() throws IOException {
		return daoTransformador.getAll();
	}

	public void addCliente(Cliente cliente) throws IOException {
		daoTransformador.add(cliente);
	}

	public void modificarCliente(Transformador transformador) throws IOException {
		daoTransformador.update(transformador);
	}
	

}
