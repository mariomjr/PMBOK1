package org.sysHotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Hospede;
import org.sysHotel.entity.Reserva;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.IReservaDao;

/**
 * @author MarioJr
 *
 */
public class ReservaDaoImpl extends GenericHibernateDao<Reserva, Long>  implements IReservaDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3879136450182696860L;

	@Override
	public Reserva getById(Long pk) {
		return super.getById(pk);
	}

	@Override
	public void save(Reserva entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

	@Override
	public void update(Reserva entity) {
		super.update(entity);
	}

	@Override
	public void delete(Reserva entity) {
		entity.setAtivoInativo(EnumAtivoInativo.INATIVO);
		super.update(entity);
	}

	@Override
	public List<Reserva> findAll() {
		return super.findAll();
	}

	@Override
	public List<Reserva> findAllAtivos() {
		return super.findAllAtivos();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> autoCompleteHospedeReserva(String strBusca){
		Session session = (Session)getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Reserva.class, "reserva");
		criteria.createAlias("reserva.hospede", "hospede");
		criteria.add(Restrictions.like("hospede.nome", strBusca).ignoreCase());
		criteria.add(Restrictions.eq("ativoInativo", EnumAtivoInativo.ATIVO));
		return criteria.list();
	}

}
