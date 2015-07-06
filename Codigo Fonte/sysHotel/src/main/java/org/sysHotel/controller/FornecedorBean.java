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
import org.sysHotel.entity.Fornecedor;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICrudPrimeFaces;
import org.sysHotel.interfaces.IFornecedorDao;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorBean implements Serializable, ICrudPrimeFaces<Fornecedor>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -996233757067595749L;
	
	@Inject
	private Fornecedor fornecedor;
	
	private Fornecedor fornecedorSelect;
	
	private List<Fornecedor> listFornecedores;
	
	@Inject
	IFornecedorDao fornecedorDao;
	
	@PostConstruct
	public void init(){
		List<Fornecedor> listFornecedor = fornecedorDao.findAllAtivos();
		setListFornecedores(listFornecedor);
	}
	
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setFornecedor(getFornecedorSelect());
	}

	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setFornecedor(new Fornecedor());
		
	}

	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getFornecedor().getId()== null){
			fornecedorDao.save(getFornecedor());
		}else{
			fornecedorDao.update(getFornecedor());
		}
		init();
	}

	@Override
	public void onRowSelect(SelectEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ActionEvent actionEvent) {
		getFornecedorSelect().setAtivoInativo(EnumAtivoInativo.INATIVO);
		fornecedorDao.update(getFornecedorSelect());
		init();
	}

	public List<Fornecedor> getListFornecedores() {
		if(listFornecedores == null){
			listFornecedores = new ArrayList<Fornecedor>();
		}
		return listFornecedores;
	}

	public void setListFornecedores(List<Fornecedor> listFornecedores) {
		this.listFornecedores = listFornecedores;
	}

	public Fornecedor getFornecedor() {
		if(fornecedor == null){
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedorSelect() {
		if(fornecedorSelect == null){
			fornecedorSelect = new Fornecedor();
		}
		return fornecedorSelect;
	}

	public void setFornecedorSelect(Fornecedor fornecedorSelect) {
		this.fornecedorSelect = fornecedorSelect;
	}

}
