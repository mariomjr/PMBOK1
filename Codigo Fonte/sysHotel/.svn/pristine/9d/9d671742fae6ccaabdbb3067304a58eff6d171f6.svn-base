package org.sysHotel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
@Entity
@XmlRootElement
public class Quarto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2140409545924744264L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String numeroQuarto;
	
	private Integer qtdePessoas;
	
	private String numeroCamas;
	
	private Integer andarQuarto;
	
	private String caracteristicas;
	
	private Double valor;

	private EnumAtivoInativo ativoInativo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(Integer qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}

	public String getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(String numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public Integer getAndarQuarto() {
		return andarQuarto;
	}

	public void setAndarQuarto(Integer andarQuarto) {
		this.andarQuarto = andarQuarto;
	}

	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Double getValor() {
		if(valor == null){
			setValor(0.0);
		}
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
	
}
