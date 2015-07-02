package org.sysHotel.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
@Entity
public class Hospede implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5230594128166930629L;


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable= false, name="nome")
	private String nome;
	
	private String numero;
	
	private String endereco;
	
	private String cpf;
	
	private Calendar dataNascimento;
	
	private String email;
	
	private EnumAtivoInativo ativoInativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
	
}
