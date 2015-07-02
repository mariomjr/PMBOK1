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
import org.sysHotel.dao.QuartoDaoImpl;
import org.sysHotel.entity.Quarto;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICrudPrimeFaces;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "quartoBean")
@SessionScoped
public class QuartoBean implements Serializable, ICrudPrimeFaces<Quarto>{
	
	private static final long serialVersionUID = -962261095009309042L;

	@Inject
	private Quarto quarto;
	
	private List<Quarto> listQuartos;
	
	private Quarto quartoSelect;
	
	@Inject
	QuartoDaoImpl quartoDao;
	
	@PostConstruct
    public void init() {
		List<Quarto> l = quartoDao.findAll();
		setListQuartos(l);
    }

	
	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getQuarto().getId()== null){
			quartoDao.save(quarto);
			
		}else{
			quartoDao.update(quarto);
		}
		init();
	}

	
	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setQuarto(new Quarto());
	}
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setQuarto(getQuartoSelect());	
	}
	
	@Override
	public void delete(ActionEvent actionEvent) {
		getQuartoSelect().setAtivoInativo(EnumAtivoInativo.INATIVO);
		quartoDao.update(getQuartoSelect());
		init();
	}

	public List<Quarto> getListQuartos() {
		if(listQuartos == null){
			listQuartos = new ArrayList<Quarto>();
		}
		return listQuartos;
	}

	public void setListQuartos(List<Quarto> listQuartos) {
		this.listQuartos = listQuartos;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Quarto getQuartoSelect() {
		if(quartoSelect == null){
			quartoSelect = new Quarto();
		}
		return quartoSelect;
	}

	public void setQuartoSelect(Quarto quartoSelect) {
		this.quartoSelect = quartoSelect;
	}

	@Override
	public void onRowSelect(SelectEvent event) {
	}

	
}
