package org.sysHotel.dao;

import java.util.List;

import javax.inject.Named;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Quarto;
import org.sysHotel.enums.EnumAtivoInativo;
import org.sysHotel.interfaces.IQuartoDao;

@Named("quartoDao")
public class QuartoDaoImpl extends GenericHibernateDao<Quarto, Long> implements IQuartoDao{

	
	private static final long serialVersionUID = -8649146652998774923L;

	
	@Override
	public List<Quarto> getRegistros() {
		return super.findAllAtivos();
	}

	@Override
	public Quarto getRegistroID(Long value) {
		return super.getById(value);
	}

	
	@Override
	public void salvar(Quarto entity) {
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

	@Override
	public int getQuantRegistros() {

		return super.findAll().size();
	}

}
