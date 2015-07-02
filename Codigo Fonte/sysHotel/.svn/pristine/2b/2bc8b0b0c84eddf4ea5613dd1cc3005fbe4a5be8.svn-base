package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.sysHotel.dao.PerfilAcessoDaoImpl;
import org.sysHotel.dao.UsuarioDao;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.entity.Usuario;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICrudPrimeFaces;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable, ICrudPrimeFaces<Usuario>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8382524308173995928L;

	@Inject
	private Usuario usuario;
	
	private List<Usuario> listUsuario;
	
	private Usuario usuarioSelect;
	
	 private Map<String,PerfilAcesso> perfisAcesso = new HashMap<String,PerfilAcesso>();
	
	@Inject
	UsuarioDao usuarioDao;
	
	@Inject
	PerfilAcessoDaoImpl perfilAcessoDao;
	
	@PostConstruct
    public void init() {
		List<Usuario> l = usuarioDao.findAllAtivos();
		setListUsuario(l);
		List<PerfilAcesso> listPerfis = perfilAcessoDao.findAllAtivos();
		for(PerfilAcesso perfil : listPerfis){
			perfisAcesso.put(perfil.getNomePerfil(),perfil);
		}
		
    }

	
	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(getUsuario().getId()== null){
			usuarioDao.salvar(usuario);
			
		}else{
			usuarioDao.update(usuario);
		}
		init();
	}
	
	public void setPerfilAcessoUsuario(PerfilAcesso perfilAcesso){
		getUsuario().setPerfilAcesso(perfilAcesso);
	}

	
	@Override
	public void prepararNovoRegistro(ActionEvent actionEvent) {
		setUsuario(new Usuario());
	}
	
	@Override
	public void prepararAlterarRegistro(ActionEvent actionEvent) {
		setUsuario(getUsuarioSelect());
	}
	
	@Override
	public void delete(ActionEvent actionEvent) {
		getUsuarioSelect().setAtivoInativo(EnumAtivoInativo.INATIVO);
		usuarioDao.update(getUsuarioSelect());
		init();
	}

	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getListUsuario() {
		if(listUsuario == null){
			listUsuario = new ArrayList<Usuario>();
		}
		return listUsuario;
	}


	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}


	public Usuario getUsuarioSelect() {
		if(usuarioSelect == null){
			usuario = new Usuario();
		}
		return usuarioSelect;
	}


	public void setUsuarioSelect(Usuario usuarioSelect) {
		this.usuarioSelect = usuarioSelect;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public Map<String,PerfilAcesso> getPerfisAcesso() {
		return perfisAcesso;
	}


	public void setPerfisAcesso(Map<String,PerfilAcesso> perfisAcesso) {
		this.perfisAcesso = perfisAcesso;
	}


	@Override
	public void onRowSelect(SelectEvent event) {
	}

}
