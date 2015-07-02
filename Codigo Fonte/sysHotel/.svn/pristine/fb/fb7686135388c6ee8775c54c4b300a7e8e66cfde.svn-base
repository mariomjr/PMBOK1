package org.sysHotel.dao;

import java.util.List;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Hospede;
import org.sysHotel.enums.EnumAtivoInativo;

public class HospedeDaoImpl extends GenericHibernateDao<Hospede, Long>{
	public List<Hospede> getRegistros() {
		return super.findAllAtivos();
	}

	public Hospede getRegistroID(Long value) {
		return super.getById(value);
	}

	
	public void salvar(Hospede entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

	
	public void update(Hospede entity) {
		super.update(entity);
	}

	public void delete(Hospede entity) {
		super.delete(entity);
		
	}

	public int getQuantRegistros() {
		return super.findAll().size();
	}
}
