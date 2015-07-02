package org.sysHotel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.sysHotel.enums.EnumAtivoInativo;

/**
 * @author MarioJr
 *
 */
@Entity
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1631181483899873752L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Calendar dataReserva;
	
	private Calendar dataOperacao;
	
	private Integer diasReserva;
	
	private EnumAtivoInativo ativoInativo;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Hospede hospede;
	
	@ManyToMany
	@JoinTable(name = "quarto_reserva", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_quarto"))
	private List<Quarto> listQuarto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Calendar getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Calendar dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public EnumAtivoInativo getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(EnumAtivoInativo ativoInativo) {
		this.ativoInativo = ativoInativo;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public List<Quarto> getListQuarto() {
		if(listQuarto == null){
			listQuarto = new ArrayList<Quarto>();
		}
		return listQuarto;
	}

	public void setListQuarto(List<Quarto> listQuarto) {
		this.listQuarto = listQuarto;
	}

	public Integer getDiasReserva() {
		return diasReserva;
	}

	public void setDiasReserva(Integer diasReserva) {
		this.diasReserva = diasReserva;
	}
	
}
