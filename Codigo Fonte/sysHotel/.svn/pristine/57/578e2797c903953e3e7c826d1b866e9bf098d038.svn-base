package org.sysHotel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.enums.Role;

/**
 * @author MarioJr
 *
 */
@Entity
@XmlRootElement
public class PerfilAcesso implements Serializable{

	private static final long serialVersionUID = -791240727894653996L;
	
	@Id
    @GeneratedValue
	private Long id;
	
	private String nomePerfil;
	
	private EnumAtivoInativo ativoInativo;
	
	@ManyToMany
	@JoinTable(name = "perfil_roles", joinColumns = @JoinColumn(name = "id_perfil", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id_role"))
	private List<Roles> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}

	public List<Roles> getRoles() {
		if(roles == null){
			roles = new ArrayList<Roles>();
		}
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public boolean hasRole(Role role) {
		Roles roles = new Roles();
		roles.setRole(role);
        return getRoles().contains(roles);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PerfilAcesso other = (PerfilAcesso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
