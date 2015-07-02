package org.sysHotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.sysHotel.entity.Reserva;
import org.sysHotel.interfaces.IReservaDao;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "relReservaBean")
@SessionScoped
public class RelatorioReservaBean {

	@Inject
	IReservaDao reservaDao;
	
	List<Reserva> listReservas;
	
	@PostConstruct
	public void init(){
		List<Reserva> listReserva = reservaDao.findAll();
		setListReservas(listReserva);
	}

	public List<Reserva> getListReservas() {
		if(listReservas == null){
			listReservas = new ArrayList<Reserva>();
		}
		return listReservas;
	}

	public void setListReservas(List<Reserva> listReservas) {
		this.listReservas = listReservas;
	}
	
}
