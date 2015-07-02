package org.sysHotel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.enums.Role;

/**
 * @author MarioJr
 *
 */
@Entity
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9075271921431072035L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String login;
	
	private String password;
	
	private EnumAtivoInativo ativoInativo;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private PerfilAcesso perfilAcesso;

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

	public PerfilAcesso getPerfilAcesso() {
		if(perfilAcesso == null){
			perfilAcesso = new PerfilAcesso();
		}
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
	public boolean hasRole(Role role){
		return getPerfilAcesso().hasRole(role);
	}

}
