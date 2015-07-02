package org.sysHotel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sysHotel.enums.EnumAtivoInativo;

@Entity
public class ServicoQuarto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8916984228842301742L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String pedido;
	
	private EnumAtivoInativo ativoInativo;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Quarto quarto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}
	
}
