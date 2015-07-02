package org.sysHotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	@SuppressWarnings("unchecked")
	public List<Hospede> autoCompleteHospede(String strBusca){
		Session session = (Session)getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Hospede.class);
		criteria.add(Restrictions.like("nome", strBusca).ignoreCase());
		criteria.add(Restrictions.eq("ativoInativo", EnumAtivoInativo.ATIVO));
		return criteria.list();
	}
	
	public Hospede hospedeByCpf(String cpf){
		Session session = (Session)getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Hospede.class);
		criteria.add(Restrictions.eq("cpf", cpf));
		criteria.add(Restrictions.eq("ativoInativo", EnumAtivoInativo.ATIVO));
		List<Hospede> hospede = criteria.list();
		if(hospede!= null && !hospede.isEmpty()){
			return hospede.get(0);
		}return null;
	}
}
