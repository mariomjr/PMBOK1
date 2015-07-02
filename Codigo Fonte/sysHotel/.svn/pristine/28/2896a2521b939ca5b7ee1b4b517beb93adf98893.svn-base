package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.sysHotel.dao.HospedeDaoImpl;
import org.sysHotel.entity.Hospede;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICrudPrimeFaces;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "hospedeBean")
@SessionScoped
public class HospedeBean implements Serializable, ICrudPrimeFaces<Hospede>{
	
	@Inject
	private Hospede hospede;
	
	private List<Hospede> listHospede;
	
	private Hospede hospedeSelect;
	
	@Inject
	HospedeDaoImpl hospedeDao;
	
	@PostConstruct
    public void init() {
		List<Hospede> l = hospedeDao.getRegistros();
		setListHospede(l);
    }

	
	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getHospede().getId()== null){
			hospedeDao.salvar(hospede);
			
		}else{
			hospedeDao.update(hospede);
		}
		init();
	}

	
	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setHospede(new Hospede());
	}
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setHospede(getHospedeSelect());	
	}
	
	@Override
	public void delete(ActionEvent actionEvent) {
		getHospedeSelect().setAtivoInativo(EnumAtivoInativo.INATIVO);
		getHospedeDao().update(getHospedeSelect());
		init();
	}

	public Hospede getHospede() {
		if(hospede == null){
			hospede = new Hospede();
		}
		return hospede;
	}


	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}


	public List<Hospede> getListHospede() {
		if(listHospede == null){
			listHospede= new ArrayList<Hospede>();
		}
		return listHospede;
	}


	public void setListHospede(List<Hospede> listHospede) {
		this.listHospede = listHospede;
	}


	public Hospede getHospedeSelect() {
		if(hospedeSelect == null){
			hospedeSelect = new Hospede();
		}
		return hospedeSelect;
	}


	public void setHospedeSelect(Hospede hospedeSelect) {
		this.hospedeSelect = hospedeSelect;
	}


	public HospedeDaoImpl getHospedeDao() {
		return hospedeDao;
	}


	public void setHospedeDao(HospedeDaoImpl hospedeDao) {
		this.hospedeDao = hospedeDao;
	}


	public void onRowSelect(SelectEvent event) {
	}

}
