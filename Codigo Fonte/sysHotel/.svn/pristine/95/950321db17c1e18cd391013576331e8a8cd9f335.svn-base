package org.sysHotel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.enums.Role;

/**
 * @author MarioJr
 *
 */
@Entity
public class Roles {
	@Id
	@GeneratedValue
	@Column(name="id_role")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private EnumAtivoInativo ativoInativo;
	
	@Transient
	private List<PerfilAcesso> listPerfilAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}

	public List<PerfilAcesso> getListPerfilAcesso() {
		if(listPerfilAcesso == null){
			listPerfilAcesso = new ArrayList<PerfilAcesso>();
		}
		return listPerfilAcesso;
	}

	public void setListPerfilAcesso(List<PerfilAcesso> listPerfilAcesso) {
		this.listPerfilAcesso = listPerfilAcesso;
	}
	
	@Override 
	public boolean equals(Object obj) { 
		if (this == obj) 
			return true; 
		if (obj == null) 
			return false; 
		if (getClass() != obj.getClass()) 
			return false; 
		return (obj instanceof Roles) ? (this.getId() == null ? this == obj : this.getId().equals(((Roles) obj).getId())) : false; 
	} 
	
	
}
