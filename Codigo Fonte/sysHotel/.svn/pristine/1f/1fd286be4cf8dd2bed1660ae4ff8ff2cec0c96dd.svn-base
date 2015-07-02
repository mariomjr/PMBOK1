package org.sysHotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.sysHotel.entity.Receita;
import org.sysHotel.interfaces.ICheckInCheckOutDao;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "relReceitasBean")
@SessionScoped
public class RelatorioReceitasBean {
	
	@Inject 
	ICheckInCheckOutDao checkInCheckOutDao;
	
	List<Receita> listReceitas;

	@PostConstruct
	public void init(){
		
	}
	
	public ICheckInCheckOutDao getCheckInCheckOutDao() {
		return checkInCheckOutDao;
	}

	public void setCheckInCheckOutDao(ICheckInCheckOutDao checkInCheckOutDao) {
		this.checkInCheckOutDao = checkInCheckOutDao;
	}

	public List<Receita> getListReceitas() {
		if(listReceitas == null){
			listReceitas = new ArrayList<Receita>();
		}
		return listReceitas;
	}

	public void setListReceitas(List<Receita> listReceitas) {
		this.listReceitas = listReceitas;
	}
	

	
}
