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
import org.primefaces.model.DualListModel;
import org.sysHotel.dao.PerfilAcessoDaoImpl;
import org.sysHotel.dao.RolesDaoImpl;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.entity.Quarto;
import org.sysHotel.entity.Roles;
import org.sysHotel.enums.Role;
import org.sysHotel.interfaces.ICrudPrimeFaces;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name="perfilAcessoBean")
@SessionScoped
public class PerfilAcessoBean implements Serializable, ICrudPrimeFaces<Quarto>{

	private static final long serialVersionUID = -7641605827038814332L;

	private List<Role> listRoles;
	
	@Inject
	PerfilAcessoDaoImpl perfilAcessoDao;
	
	PerfilAcesso perfilAcesso;
	
	PerfilAcesso perfilAcessoSelect;
	
	List<PerfilAcesso> listPerfilAcessos;
	
	private DualListModel<Roles> roles;
	
	@Inject
	RolesDaoImpl roleDao;

	@PostConstruct
	public void init(){
		List<PerfilAcesso> l = perfilAcessoDao.getRegistros();
		setListPerfilAcessos(l);
	}

	public void carregaRoles(){
		if(getPerfilAcesso().getId()!= null){
			
 			List<Roles> listRoles = roleDao.findAll();
 			for(Roles role : getPerfilAcesso().getRoles()){
 				if(listRoles.contains(role)){
 					listRoles.remove(role);
 				}
 			}
 			
			setRoles(new DualListModel<Roles>(listRoles,getPerfilAcesso().getRoles()));
			
			
		}else{
			List<Roles> listTargetRoles = new ArrayList<Roles>();
			
 			List<Roles> listRoles = roleDao.findAll();
			setRoles(new DualListModel<Roles>(listRoles,listTargetRoles));
		}
	}
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setPerfilAcesso(getPerfilAcessoSelect());
		carregaRoles();
		
	}

	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setPerfilAcesso(new PerfilAcesso());
		carregaRoles();
	}

	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getPerfilAcesso().getId()== null){
			if(getRoles().getTarget()!= null){
				getPerfilAcesso().setRoles(getRoles().getTarget());
			}
			perfilAcessoDao.salvar(getPerfilAcesso());
		}else{
			if(getRoles().getTarget()!= null){
				getPerfilAcesso().setRoles(getRoles().getTarget());
			}
			perfilAcessoDao.update(getPerfilAcesso());
		}
		init();
	}

	@Override
	public void onRowSelect(SelectEvent event) {
		
	}

	@Override
	public void delete(ActionEvent actionEvent) {
		
		
	}
	
	public List<Role> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Role> listRoles) {
		this.listRoles = listRoles;
	}

	public PerfilAcesso getPerfilAcesso() {
		if(perfilAcesso == null){
			perfilAcesso = new PerfilAcesso();
		}
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public List<PerfilAcesso> getListPerfilAcessos() {
		if(listPerfilAcessos == null){
			listPerfilAcessos = new ArrayList<PerfilAcesso>();
		}
		return listPerfilAcessos;
	}

	public void setListPerfilAcessos(List<PerfilAcesso> listPerfilAcessos) {
		this.listPerfilAcessos = listPerfilAcessos;
	}


	public PerfilAcesso getPerfilAcessoSelect() {
		if(perfilAcessoSelect == null){
			perfilAcessoSelect = new PerfilAcesso();
		}
		return perfilAcessoSelect;
	}


	public void setPerfilAcessoSelect(PerfilAcesso perfilAcessoSelect) {
		this.perfilAcessoSelect = perfilAcessoSelect;
	}

	public DualListModel<Roles> getRoles() {
		if(roles== null){
			roles = new DualListModel<Roles>();
		}
		return roles;
	}

	public void setRoles(DualListModel<Roles> roles) {
		this.roles = roles;
	}

}
