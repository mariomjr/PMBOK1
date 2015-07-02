package org.sysHotel.dao;

import org.sysHotel.dao.generic.GenericHibernateDao;
import org.sysHotel.entity.Roles;
import org.sysHotel.enums.EnumAtivoInativo;

public class RolesDaoImpl extends GenericHibernateDao<Roles, Long>{
	
	public void salvar(Roles entity) {
		entity.setAtivoInativo(EnumAtivoInativo.ATIVO);
		super.save(entity);
	}

}
