package ar.com.sge.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.sge.geografia.Transformador;


public interface DaoTransFormadores {
	public void add(Transformador unTransformador) throws IOException ;
	public void delete(Transformador unTransformador) throws IOException;
	public List<Transformador> getAll() throws IOException;
	public void update(Transformador unTransformador);

}
