package org.sysHotel.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.sysHotel.dao.UsuarioDao;
import org.sysHotel.entity.Usuario;
import org.sysHotel.interfaces.ILoginBean;
import org.sysHotel.util.UtilUser;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "logarBean")
@SessionScoped
public class LogarBean implements ILoginBean{
	
	private static final long serialVersionUID = -6775769722079847376L;
	
	@Inject
	Usuario usuarioLogado;
	
	@Inject
	UsuarioDao usuarioDao;
	
	public String autenticar() {
		Usuario loginAuthenticate = usuarioDao.usuarioByLogin(getUsuarioLogado().getLogin());
		if(loginAuthenticate!= null && loginAuthenticate.getId()!= null){
			if(loginAuthenticate.getPassword().equals(getUsuarioLogado().getPassword())){
				setUsuarioLogado(loginAuthenticate);
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		        session.setAttribute("usuarioLogado", getUsuarioLogado());
		        return "/home.xhtml";
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Senha inválida!"));
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "Usuário não encontrado!"));	
		}
		return "";
	}

	
    public String logout() {
        HttpSession session = UtilUser.getSession();
        session.invalidate();
        return "/login.xhtml";
    }
    
    public boolean isLogado(){

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario user =  (Usuario) session.getAttribute("usuarioLogado");
        if(user!= null)
        	return true;
        else 
        	return false;
    }


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
