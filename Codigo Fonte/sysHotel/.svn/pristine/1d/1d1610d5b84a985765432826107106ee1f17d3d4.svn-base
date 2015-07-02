package org.sysHotel.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.sysHotel.dao.UsuarioDao;
import org.sysHotel.entity.LoginUser;
import org.sysHotel.entity.PerfilAcesso;
import org.sysHotel.enums.Role;
import org.sysHotel.interfaces.ILoginBean;
import org.sysHotel.util.UtilUser;

/**
 * @author MarioJr
 *
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements ILoginBean{
	
	private static final long serialVersionUID = -6775769722079847376L;
	
	@Inject
	LoginUser login;
	
	@Inject
	UsuarioDao usuarioDao;
	
	public String loginProject() {
//		setLogin(usuarioDao.buscaUserByLogin(getLogin().getLogin()));
//		if(getLogin().getId()!= null){
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	        session.setAttribute("usuarioLogado", getLogin());
	        return "/home.xhtml";
//		}else{
//			FacesContext.getCurrentInstance().addMessage("Usuário não encontrado!", null);
//			return null;
//		}
 
       
	}

	
    public String logout() {
        HttpSession session = UtilUser.getSession();
        session.invalidate();
        return "/login.xhtml";
    }
    
    public boolean isLogado(){

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            LoginUser user =  (LoginUser) session.getAttribute("usuarioLogado");
            if(user!= null) return true;
            else return false;
    }
    
	public LoginUser getLogin() {
		if(login == null){
			login = new LoginUser();
		}
		return login;
	}

	public void setLogin(LoginUser login) {
		this.login = login;
	}
	
	
}
