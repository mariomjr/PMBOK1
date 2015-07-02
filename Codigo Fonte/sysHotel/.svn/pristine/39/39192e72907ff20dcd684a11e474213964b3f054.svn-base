package org.sysHotel.dao;

import java.util.List;

import javax.inject.Named;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Quarto;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.IQuartoDao;

/**
 * @author MarioJr
 *
 */
@Named("quartoDao")
public class QuartoDaoImpl extends GenericHibernateDao<Quarto, Long> implements IQuartoDao{

	
	private static final long serialVersionUID = -8649146652998774923L;

	
	@Override
	public void save(Quarto entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

	@Override
	public void update(Quarto entity) {
		super.update(entity);
	}

	@Override
	public void delete(Quarto entity) {
		super.delete(entity);
	}
	
	public List<Quarto> listQuartosDisponiveis(){
//		Session session = (Session)getEntityManager().getDelegate();
//		Criteria criteria = session.createCriteria(Quarto.class);
//		criteria.add();
		return super.findAllAtivos();
		
	}

}
