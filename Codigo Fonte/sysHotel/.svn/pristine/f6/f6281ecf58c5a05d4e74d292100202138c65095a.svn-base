package org.sysHotel.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T> extends Serializable {
	
	public List<T> getRegistros();
	
	public T getRegistroID(Long value);
	
	void salvar(T entity);
		
	void update(T entity);

	void delete(T entity);

	int getQuantRegistros();

}
