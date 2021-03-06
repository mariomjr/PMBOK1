package org.sysHotel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.sysHotel.dao.PerfilAcessoDaoImpl;
import org.sysHotel.dao.UsuarioDao;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.entity.Usuario;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.ICrudPrimeFaces;

/**
 * @author MarioJr
 *
 */
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
	
	 private Map<String,Long> perfisAcesso = new HashMap<String,Long>();
	
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
			perfisAcesso.put(perfil.getNomePerfil(),perfil.getId());
		}
		
    }

	
	@Override
	public void salvarAlterar(ActionEvent actionEvent) {
		if(validaDados()){
			if(getUsuario().getId()== null){
				usuario.setPerfilAcesso(perfilAcessoDao.getById(usuario.getPerfilAcesso().getId()));
				usuarioDao.salvar(usuario);
				
			}else{
				usuarioDao.update(usuario);
			}
			init();
		}
	}
	
	private boolean validaDados() {
		if(getUsuario().getPerfilAcesso().getId()== 0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuário não inserido, insira perfil de acesso!"));
			return false;
		}
		if(getUsuario().getLogin()== null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuário não inserido, insira o login!"));
			return false;
		}
		if(usuarioDao.usuarioByLogin(getUsuario().getLogin())!= null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuário não inserido, login já existe!"));
			return false;
		}
		if(getUsuario().getPassword()== null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuário não inserido, insira a senha!"));
			return false;
		}
		return true;
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
		getUsuarioSelect().setPerfilAcesso(null);
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


	public Map<String,Long> getPerfisAcesso() {
		return perfisAcesso;
	}


	public void setPerfisAcesso(Map<String,Long> perfisAcesso) {
		this.perfisAcesso = perfisAcesso;
	}


	@Override
	public void onRowSelect(SelectEvent event) {
	}

}
