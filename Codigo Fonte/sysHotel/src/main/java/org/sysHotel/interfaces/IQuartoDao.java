package org.sysHotel.interfaces;

import java.util.List;

import org.sysHotel.entity.Quarto;

public interface IQuartoDao extends IGenericDao<Quarto>{

	public List<Quarto> listQuartosDisponiveis();
}
