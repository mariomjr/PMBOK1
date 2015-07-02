package org.sysHotel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.sysHotel.enums.Role;

@Entity
@XmlRootElement
public class LoginUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 193639066436580798L;


	@Id
    @GeneratedValue
	private Long id;
	
	private String password;
	
	@NotNull
	private String login;
	
	private PerfilAcesso perfilAcesso;
	
	@Transient
	private boolean logado = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
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
	
	public boolean hasRole(Role role){
		return getPerfilAcesso().hasRole(role);
	}
	
}
