package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.sysHotel.entity.Fornecedor;
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
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		
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
		
	}

	@Override
	public void onRowSelect(SelectEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ActionEvent actionEvent) {
		
		
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
