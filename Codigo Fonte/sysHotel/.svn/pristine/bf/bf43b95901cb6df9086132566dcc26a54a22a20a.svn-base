package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.hibernate.Hibernate;
import org.primefaces.event.SelectEvent;
import org.sysHotel.dao.HospedeDaoImpl;
import org.sysHotel.entity.Hospede;
import org.sysHotel.entity.Quarto;
import org.sysHotel.entity.Reserva;
import org.sysHotel.interfaces.ICrudPrimeFaces;
import org.sysHotel.interfaces.IQuartoDao;
import org.sysHotel.interfaces.IReservaBean;
import org.sysHotel.interfaces.IReservaDao;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "reservaBean")
@SessionScoped
public class ReservaBean implements Serializable, ICrudPrimeFaces<Reserva>,IReservaBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1296974024641415224L;

	@Inject
	private Reserva reserva;
	
	private Reserva reservaSelect;
	
	private List<Reserva> listReservas;
	
	private List<Quarto> listQuartosDisponiveis;
	
	private List<Quarto> listQuartosFiltro;
	
	private Quarto quartoSelect;
	
	private String autoCompleteHospede;
	
	@Inject
	IReservaDao reservaDao;
	
	@Inject
	IQuartoDao quartoDao;
	
	@Inject
	HospedeDaoImpl hospedeDao;
	
	@PostConstruct
	public void init(){
		List<Reserva> listReserva = reservaDao.findAllAtivos();
		setListReservas(listReserva);
	}
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		Hibernate.initialize(getReservaSelect().getListQuarto());
		setReserva(getReservaSelect());
	}

	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setAutoCompleteHospede("");
		setReserva(new Reserva());
	}

	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(validarDados()){
			buscaHospedeSelecionado();
			if(getReserva().getId()== null){
				reservaDao.save(getReserva());
			}else{
				reservaDao.update(getReserva());
			}
			init();
		}
		
	}

	private void buscaHospedeSelecionado() {
		if(getAutoCompleteHospede()!= null && !getAutoCompleteHospede().equals("")){
			String[] hospede =getAutoCompleteHospede().split(" - ");
			getReserva().setHospede(hospedeDao.hospedeByCpf(hospede[1]));
		}
	}

	private boolean validarDados() {
		return true;
	}

	@Override
	public void onRowSelect(SelectEvent event) {
		
	}
	
	
	public void onRowQuartoSelect(SelectEvent event) {
		if(!getReserva().getListQuarto().contains(getQuartoSelect())){
			getReserva().getListQuarto().add(getQuartoSelect());
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Quarto já adicionado!"));
		}
	}
	
	public List<String> listHospedeAuto(String event){
		List<Hospede> listHospedes = hospedeDao.autoCompleteHospede(event);
		List<String> listString = new ArrayList<String>();
		for(Hospede hospede: listHospedes){
			listString.add(hospede.getNome()+" - "+hospede.getCpf());
		}
		return listString;
	}

	
	public void inicializaQuartos(){
		setQuartoSelect(new Quarto());
		setListQuartosDisponiveis(quartoDao.listQuartosDisponiveis());
	}
	
	public void removerQuarto(Quarto quarto){
		getReserva().getListQuarto().remove(quarto);
	}

	@Override
	public void delete(ActionEvent actionEvent) {
		reservaDao.delete(getReservaSelect());
		init();
	}

	public Reserva getReserva() {
		if(reserva == null){
			reserva = new Reserva();
		}
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Reserva getReservaSelect() {
		if(reservaSelect == null){
			reservaSelect = new Reserva();
		}
		return reservaSelect;
	}

	public void setReservaSelect(Reserva reservaSelect) {
		this.reservaSelect = reservaSelect;
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

	public List<Quarto> getListQuartosDisponiveis() {
		if(listQuartosDisponiveis == null){
			listQuartosDisponiveis = new ArrayList<Quarto>();
		}
		return listQuartosDisponiveis;
	}

	public void setListQuartosDisponiveis(List<Quarto> listQuartosDisponiveis) {
		this.listQuartosDisponiveis = listQuartosDisponiveis;
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

	public List<Quarto> getListQuartosFiltro() {
		return listQuartosFiltro;
	}

	public void setListQuartosFiltro(List<Quarto> listQuartosFiltro) {
		this.listQuartosFiltro = listQuartosFiltro;
	}

	public String getAutoCompleteHospede() {
		return autoCompleteHospede;
	}

	public void setAutoCompleteHospede(String autoCompleteHospede) {
		this.autoCompleteHospede = autoCompleteHospede;
	}

}
