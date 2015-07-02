package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.sysHotel.entity.CheckInCheckOut;
import org.sysHotel.entity.Reserva;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICheckInCheckOutDao;
import org.sysHotel.interfaces.ICrudPrimeFaces;
import org.sysHotel.interfaces.IReservaDao;

/**
 * @author MarioJr
 *
 */
@SessionScoped
@ManagedBean(name="checkInCheckOutBean")
public class CheckInCheckOutBean implements Serializable, ICrudPrimeFaces<CheckInCheckOut>{

	@Inject
	private CheckInCheckOut checkInCheckOut;
	
	private List<CheckInCheckOut> listCheckInCheckOut;
	
	private CheckInCheckOut checkInCheckOutSelect;
	
	private String hospedeReservaAuto;
	
	@Inject
	ICheckInCheckOutDao checkInCheckOutDao;
	
	@Inject
	IReservaDao reservaDao;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -679662956189171814L;

	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setCheckInCheckOut(getCheckInCheckOutSelect());
	}
	
	public List<String> listHospedeAuto(String event){
		List<Reserva> listReservas = reservaDao.autoCompleteHospedeReserva(event);
		List<String> listString = new ArrayList<String>();
		for(Reserva reserva: listReservas){
			listString.add(reserva.getHospede().getNome()+" - "+reserva.getHospede().getCpf());
		}
		return listString;
	}

	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setCheckInCheckOut(new CheckInCheckOut());
		
	}

	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getCheckInCheckOut().getId()== null){
			checkInCheckOutDao.save(getCheckInCheckOut());
		}else{
			checkInCheckOutDao.update(getCheckInCheckOut());
		}
		
	}

	@Override
	public void onRowSelect(SelectEvent event) {
		
	}

	@Override
	public void delete(ActionEvent actionEvent) {
		getCheckInCheckOutSelect().setAtivoInativo(EnumAtivoInativo.INATIVO);
		checkInCheckOutDao.update(getCheckInCheckOutSelect());
	}

	public CheckInCheckOut getCheckInCheckOut() {
		if(checkInCheckOut == null){
			checkInCheckOut = new CheckInCheckOut();
		}
		return checkInCheckOut;
	}

	public void setCheckInCheckOut(CheckInCheckOut checkInCheckOut) {
		this.checkInCheckOut = checkInCheckOut;
	}

	public List<CheckInCheckOut> getListCheckInCheckOut() {
		if(listCheckInCheckOut == null){
			listCheckInCheckOut = new ArrayList<CheckInCheckOut>();
		}
		return listCheckInCheckOut;
	}

	public void setListCheckInCheckOut(List<CheckInCheckOut> listCheckInCheckOut) {
		this.listCheckInCheckOut = listCheckInCheckOut;
	}

	public CheckInCheckOut getCheckInCheckOutSelect() {
		if(checkInCheckOutSelect == null){
			checkInCheckOutSelect = new CheckInCheckOut();
		}
		return checkInCheckOutSelect;
	}

	public void setCheckInCheckOutSelect(CheckInCheckOut checkInCheckOutSelect) {
		this.checkInCheckOutSelect = checkInCheckOutSelect;
	}

	public String getHospedeReservaAuto() {
		return hospedeReservaAuto;
	}

	public void setHospedeReservaAuto(String hospedeReservaAuto) {
		this.hospedeReservaAuto = hospedeReservaAuto;
	}

}
