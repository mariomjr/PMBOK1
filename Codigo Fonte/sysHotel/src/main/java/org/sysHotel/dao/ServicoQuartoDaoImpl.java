package org.sysHotel.dao;

import java.util.List;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.ServicoQuarto;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.IServicoQuartoDao;


/**
 * @author MarioJr
 *
 */
public class ServicoQuartoDaoImpl extends GenericHibernateDao<ServicoQuarto,Long> implements IServicoQuartoDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8296205723953774700L;

	@Override
	public ServicoQuarto getById(Long pk) {
		return super.getById(pk);
	}

	@Override
	public void save(ServicoQuarto entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

	@Override
	public void update(ServicoQuarto entity) {
		super.update(entity);
	}

	@Override
	public void delete(ServicoQuarto entity) {
		entity.setAtivoInativo(EnumAtivoInativo.INATIVO);
		super.update(entity);
	}

	@Override
	public List<ServicoQuarto> findAll() {
		return super.findAll();
	}

	@Override
	public List<ServicoQuarto> findAllAtivos() {
		return super.findAllAtivos();
	}
}
