package org.sysHotel.interfaces;

import java.util.List;

import org.sysHotel.entity.Reserva;

public interface IReservaDao extends IGenericDao<Reserva>{
	public List<Reserva> autoCompleteHospedeReserva(String strBusca);
}
