package org.sysHotel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.sysHotel.enums.EnumAtivoInativo;

@Entity
public class Fornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048660255483307961L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nomeFornecedor;
	
	@Column
	private String telefone;
	
	@Column
	private String cnpj;
	
	private EnumAtivoInativo ativoInativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
}
